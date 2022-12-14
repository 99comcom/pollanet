package com.example.finalproject;

import static com.example.finalproject.LoginPage.RemoteService.BASE_URL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.LoginPage.RemoteService;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Board_Read_Activity extends AppCompatActivity {
    Context context;
    String user_ID;
    String[] report;

    Toolbar toolbar;
    int id;
    RemoteService remoteService;
    Retrofit retrofit;
    LinearLayoutManager linearLayoutManager;
    TextView category, date, title, user_id, content, recommend_total, comment_count, update,
            delete,boardReport;
    EditText comment_insert;
    Button btn_comment_insert;
    ImageView image, recommend_heart;
    Intent intent;
    RecyclerView list;
    CommentAdapter adapter;
    List<CommentVO> covo = new ArrayList<>();
    UserReportVO uvo;
    ReportVO rvo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_read);

        intent = getIntent();
        user_ID = intent.getStringExtra("user_id");
        System.out.println("userId ...................= " + user_ID);


        toolbar=(Toolbar) findViewById(R.id.board_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");



        category = findViewById(R.id.board_read_category);
        date = findViewById(R.id.board_read_date);
        title = findViewById(R.id.board_read_title);
        user_id = findViewById(R.id.board_read_id);
        content = findViewById(R.id.board_read_content);
        recommend_total = findViewById(R.id.board_read_recommend_total);
        image = findViewById(R.id.board_read_image);
        comment_count = findViewById(R.id.comment_count);
        update = findViewById(R.id.board_read_update);
        delete = findViewById(R.id.board_read_delete);
        recommend_heart = findViewById(R.id.recommend_heart);

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        remoteService = retrofit.create(RemoteService.class);

//        intent=getIntent();
        id = intent.getIntExtra("id", 0);

        //?????? ???????????? ??????
        Call<BoardVO> call = remoteService.boardRead(id);
        call.enqueue(new Callback<BoardVO>() {
            @Override
            public void onResponse(Call<BoardVO> call, Response<BoardVO> response) {
                BoardVO vo = response.body();
                System.out.println("vo =.................. " + vo);
                user_id.setText(vo.getB_user_id());
                title.setText(vo.getB_title());
                category.setText(vo.getB_category());
                date.setText(vo.getB_register_Date());
                content.setText(vo.getB_content());
                recommend_total.setText(String.valueOf(vo.getB_heart()));
//                image.setImageBitmap(BitmapFactory.decodeFile(vo.getB_image()));
                comment_count.setText(String.valueOf(vo.getB_comment_count()));

                //?????? ????????? read??? ???????????? ?????????
                String strImage = vo.getB_image();
                System.out.println(".................." + strImage);
                if (strImage != null && !strImage.equals("")) {
                    Picasso.with(context).load("http://192.168.0.108:8088/api/display?fileName=" + strImage).into(image);
                    System.out.println("vo??????????????? ?????????????????? ????????? = " + vo.getB_image());
                }
                System.out.println("vo.getB_user_id() = " + vo.getB_user_id());

                recommend_heart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BoardHeartVO boardHeartVO = new BoardHeartVO();
                        boardHeartVO.setH_board_code(id);
                        boardHeartVO.setH_user_id(user_ID);
                        System.out.println("user_ID????????? ????????? = " + user_ID);
                        boardHeartVO.setH_sort(Integer.toString(vo.getB_heart()));
                        System.out.println("boardHeartVO = " + boardHeartVO);
                        Call<Integer> heartCall = remoteService.userHeart(boardHeartVO);
                        heartCall.enqueue(new Callback<Integer>() {
                            @Override
                            public void onResponse(Call<Integer> call, Response<Integer> response) {
                                System.out.println("response???????????? ???????????? = " + response.body());
                                if (response.body().equals(0)){
                                    recommend_total.setText(String.valueOf(vo.getB_heart()+1));
                                    Call<Void> heartinsert = remoteService.heart(vo, user_ID);
                                    heartinsert.enqueue(new Callback<Void>() {
                                        @Override
                                        public void onResponse(Call<Void> call, Response<Void> response) {
                                            System.out.println("response???????????????  = " + response.code());
                                            recommend_heart.setClickable(false);
                                        }
                                        @Override
                                        public void onFailure(Call<Void> call, Throwable t) {
                                            System.out.println("t??????????????? ?????? = " + t);
                                        }
                                    });

                                }
                            }

                            @Override
                            public void onFailure(Call<Integer> call, Throwable t) {
                                System.out.println("t???????????? ?????????????????? = " + t);
                            }
                        });



                    }
                });
                //?????? ???????????? ???????????? ???????????? ??????,???????????? ?????????
                if (user_ID.equals(vo.getB_user_id())) {
                    update.setVisibility(View.VISIBLE);
                    delete.setVisibility(View.VISIBLE);
                    //????????????
                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Board_Read_Activity.this, Board_Update_Activity.class);
                            intent.putExtra("user_id", user_ID);
                            intent.putExtra("board_code", vo.getBoard_code());
                            startActivity(intent);
                        }
                    });
                    //???????????????
                    delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder box = new AlertDialog.Builder(Board_Read_Activity.this, R.style.AlertDialogTheme);
                            box.setTitle("");
                            box.setMessage(vo.getBoard_code() + "??? ???????????? ?????????????????????????");
                            box.setPositiveButton("???", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    BoardVO boardVO = new BoardVO();
                                    int code = vo.getBoard_code();
                                    vo.setB_del("1");
                                    Call<Void> call = remoteService.boardDelete(code, vo);
                                    call.enqueue(new Callback<Void>() {
                                        @Override
                                        public void onResponse(Call<Void> call, Response<Void> response) {
                                            Toast.makeText(Board_Read_Activity.this, "?????????????????????.", Toast.LENGTH_SHORT).show();
                                            finish();
                                            intent = new Intent(Board_Read_Activity.this, MainActivity.class);
                                        }

                                        @Override
                                        public void onFailure(Call<Void> call, Throwable t) {
                                            System.out.println("t = " + t);
                                        }
                                    });
                                }
                            });
                            box.setNegativeButton("?????????", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                            box.show();
                        }
                    });
                }
            }
            @Override
            public void onFailure(Call<BoardVO> call, Throwable t) {
                System.out.println("t = " + t);
            }
        });
        //??????
        boardReport = findViewById(R.id.board_report);
        boardReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<List<ReportVO>> reportList = remoteService.reportList();
                reportList.enqueue(new Callback<List<ReportVO>>() {
                    @Override
                    public void onResponse(Call<List<ReportVO>> call, Response<List<ReportVO>> response) {
                        ArrayList array = new ArrayList(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<ReportVO>> call, Throwable t) {

                    }
                });
                AlertDialog.Builder box = new AlertDialog.Builder(Board_Read_Activity.this, R.style.AlertDialogTheme);
                report = getResources().getStringArray(R.array.report);
                box.setTitle("??????");
                box.setItems(report, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("which.//////////////////////  = " + which);
                        int code = which+1;
                        UserReportVO uvo = new UserReportVO();
                        uvo.setReport_code(code);
                        uvo.setReporter_id(user_ID);
                        uvo.setReport_board_code(id);
                        Call<Void> report = remoteService.BoardReport(uvo);
                        report.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                System.out.println("response = " + response.toString());
                                AlertDialog.Builder box = new AlertDialog.Builder(Board_Read_Activity.this, R.style.AlertDialogTheme);
                                box.setTitle("????????? ?????????????????????.");
                                box.setMessage("????????? ?????? ??????????????????.");
                                box.setPositiveButton("??????",null);
                                box.show();
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                System.out.println("t = " + t);
                            }
                        });
                    }
                });
                box.setNegativeButton("??????",null);
                box.show();
            }
        });


        //?????? ?????????
        list = findViewById(R.id.commend_list);
        Call<List<CommentVO>> listCall = remoteService.commentRead(id);
        listCall.enqueue(new Callback<List<CommentVO>>() {
            @Override
            public void onResponse(Call<List<CommentVO>> call, Response<List<CommentVO>> response) {

                System.out.println("vo.getBoard_code() = " + response.code());
                covo = response.body();
                System.out.println("response =.................... " + response.body());
                System.out.println("array.size() = " + covo.size());

                LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                list.setLayoutManager(layoutManager);
                adapter = new CommentAdapter(context, covo, user_ID);
                list.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<CommentVO>> call, Throwable t) {
                System.out.println("t = ????????? ??????................. " + t);
            }
        });


        //?????? ??????
        comment_insert = findViewById(R.id.comment_insert);
        btn_comment_insert = findViewById(R.id.btn_comment_insert);
        btn_comment_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strComment = comment_insert.getText().toString();

                if (strComment.equals("")) {
                    Toast.makeText(Board_Read_Activity.this, "????????? ??????????????????", Toast.LENGTH_SHORT).show();
                    return;
                }
                CommentVO commentVO = new CommentVO();
                commentVO.setC_comment(strComment);
                commentVO.setC_user_id(user_ID);
                commentVO.setBoard_Code(id);
                Call<Void> commentCall = remoteService.commentInsert(commentVO);
                commentCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(Board_Read_Activity.this, "????????? ?????????????????????.", Toast.LENGTH_SHORT).show();
                        System.out.println("response = " + response.code());
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        System.out.println("t....................................... = " + t);
                    }
                });
                onRestart();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}