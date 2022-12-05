package com.example.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.BoardDAO;
import com.example.domain.BoardVO;
import com.example.domain.MissionVO;
import com.example.service.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardRESTController {
	@Autowired
	BoardDAO dao;
	@Autowired
	BoardService service;
	

	//�Խñ� ��ü ����Ʈ 			/api/board/list?page=&num=
	@RequestMapping("list")
	public HashMap<String, Object> boardList(String b_category,String search,int page, int num){
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", dao.boardList(b_category, search, page, num));
		map.put("total", dao.boardListtotal(b_category, search));
		return map;
	}
	//�Խñ� ��ü ����Ʈ(�ȵ�) 			/api/board/list?
		@RequestMapping("listand")
		public List<BoardVO> boardListand(String b_title){
			return dao.boardListand(b_title);
		}
		//�Խñ� ��õ��4��			/api/board/list?
		@RequestMapping("listheart")
		public List<BoardVO> boardListheart(){
			return dao.boardListheart();
		}

	//Ư�� ������ �Խñ� ����Ʈ			/api/board/userBoardList/b_user_id=?page=&num=
	@RequestMapping("/userBoardList/{b_user_id}")
	public List<BoardVO> userBoardList(@PathVariable String b_user_id, int page, int num){
		return dao.userBoardList(b_user_id, page, num);
	}

	//Ư�� �Խñ� �б� 				/api/board/read/board_code
	@RequestMapping("/read/{board_code}")
	public BoardVO boardRead(@PathVariable int board_code){

		return dao.boardRead(board_code);
	}	

	//Ư�� �Խù� ����
	@RequestMapping(value="/delete/{board_code}", method=RequestMethod.POST)
	public void boardDelete(@PathVariable int board_code){
		BoardVO vo = dao.boardRead(board_code);
		vo.setB_del("1");
		dao.boardDelete(vo);
	}
	//Ư�� �Խù� ����(������)
		@RequestMapping(value="/delete/{board_code}/{report_content}", method=RequestMethod.POST)
		public void boardDelete(@PathVariable int board_code, @PathVariable int report_content){
			BoardVO vo = dao.boardRead(board_code);
			vo.setB_del("1");
			vo.setB_report_content(report_content);
			dao.boardDeleteAdmin(vo);
		}

	//Ư�� �Խù� �Ű�
	@RequestMapping(value="/report/{board_code}", method=RequestMethod.POST)
	public void boardReport (@PathVariable int board_code){
		dao.boardReport(board_code);
	}
	//Ư�� �Խñ� ��õ
	@RequestMapping(value="/recommend/{board_code}", method=RequestMethod.POST)
	public void boardRecommned (@PathVariable int board_code){
		dao.boardRecommned(board_code);
	}
	//�Խù� ���(�ȵ���̵�)
    @ResponseBody
    @RequestMapping(value="/insert",method=RequestMethod.POST)
    public void insert(
          @RequestParam(value = "b_user_id")String b_user_id,
          @RequestParam(value = "b_content")String b_content,
          @RequestParam(value = "b_title")String b_title,
          @RequestParam(value = "b_category")String b_category,
          @RequestParam(value = "b_image", required = true)MultipartFile b_image
          ) throws Exception  {
       BoardVO vo = new BoardVO();
       String path="c:/upload/board/";
       String name=b_image.getOriginalFilename();
       File newFile=new File(path+name);
       if(!newFile.exists()){
          b_image.transferTo(newFile);
       }
       vo.setB_image("/upload/board/"+name);
       vo.setB_category(b_category);
       vo.setB_user_id(b_user_id);
       vo.setB_content(b_content);
       vo.setB_title(b_title);      
       System.out.println(vo.toString());
    dao.boardInsert(vo);
 }
    //�Խù� ����(�ȵ���̵�)
       @ResponseBody
       @RequestMapping(value="/update/{board_code}",method=RequestMethod.POST)
       public void update(
           @PathVariable int board_code,
             @RequestParam(value = "b_user_id")String b_user_id,
             @RequestParam(value = "b_content")String b_content,
             @RequestParam(value = "b_category")String b_category,
             @RequestParam(value = "b_title")String b_title,
             @RequestParam(value = "b_image", required = true)MultipartFile b_image
             ) throws Exception  {
          BoardVO vo = new BoardVO();
          String path="c:/upload/board/";
          String name=b_image.getOriginalFilename();
          File newFile=new File(path+name);
          if(!newFile.exists()){
             b_image.transferTo(newFile);
          }
          vo.setB_image("/upload/board/"+name);
          vo.setBoard_Code(board_code);
          vo.setB_user_id(b_user_id);
          vo.setB_content(b_content);
          vo.setB_category(b_category);
          vo.setB_title(b_title);      
          System.out.println(vo.toString());
       dao.boardUpdate(vo);
    }
	//�Խù� ���
	@RequestMapping(value="/insertWeb", method=RequestMethod.POST)
	public void insert(BoardVO vo, MultipartHttpServletRequest multi) throws Exception{
		if(multi.getFile("file") != null){
			MultipartFile file=multi.getFile("file");
			String path="c:/upload/board/";
			String fileName=file.getOriginalFilename();
			File newFile = new File(path+fileName);
			if(!newFile.exists()) file.transferTo(newFile);
			vo.setB_image("/upload/board/"+fileName);
		}
		System.out.println(vo.toString());
		dao.boardInsert(vo);
	}
	//�Խù� ����
	@RequestMapping(value="/updateWeb", method=RequestMethod.POST)
	public void update(BoardVO vo, MultipartHttpServletRequest multi)throws Exception{	
		 if(multi.getFile("file") != null){ //������ ������
	         MultipartFile file=multi.getFile("file");
	         String path="c:/upload/board/";
	         String fileName=file.getOriginalFilename();
	         File newFile=new File(path+fileName);
	         if(!newFile.exists()) file.transferTo(newFile);//���ε��ϰ����ϴ� ������ newFile��
			 vo.setB_image(path + fileName);
		}
		dao.boardUpdate(vo);
	}

	//�Ű� �Խñ� Ȯ��
	@RequestMapping("/reportList")
	public List<BoardVO> reportList(int page, int num){
		return dao.boardReportList(page, num);
	}

	//���� �Խñ� Ȯ��
	@RequestMapping("/delList")
	public List<BoardVO> delList(int page, int num){
		return dao.boardDelList(page, num);
	}
	
	//������
		@RequestMapping("/noticeList")
		public List<BoardVO> noticeList(int page, int num){
			return dao.boardNoticeList(page, num);
		}
		//���ƿ�
		@RequestMapping(value="/heart/{h_user_id}", method=RequestMethod.POST)
		public void heart(@RequestBody BoardVO vo, @PathVariable String h_user_id){
			System.out.println("11111.........1111.........."+vo);
			service.heart(vo, h_user_id);
		}
		
		@RequestMapping(value="/heartCancel/{h_user_id}", method=RequestMethod.POST)
		public void heartCancel(@RequestBody BoardVO vo, @PathVariable String h_user_id){
			service.heartCancel(vo, h_user_id);
		}
		//�Խñ� ��ü ����Ʈ 			/api/board/list?page=&num=
		@RequestMapping("reportlist")
		public HashMap<String, Object> reportboardList(int page, int num){
			HashMap<String, Object> map = new HashMap<>();
			map.put("list", dao.boardReportList(page, num));
			map.put("total", dao.ReportBoardTotal());
			return map;
		}
		
}
