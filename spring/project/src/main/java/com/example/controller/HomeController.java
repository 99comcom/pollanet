package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="uploadPath")
	private String path;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping("/chat")
	public String chat(){
		return "chat";
	}
	
	//웹서버 이미지 출력
	@RequestMapping("/api/display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName)throws Exception{
		ResponseEntity<byte[]> image=null;
		File file=new File(fileName);
		HttpHeaders header=new HttpHeaders();
		header.add("Content-type", Files.probeContentType(file.toPath()));
		image=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		return image;
	} 
	
	//네트워크 이미지 다운
	@RequestMapping(value="/api/download", method=RequestMethod.POST)
	@ResponseBody
	public void download(String image){
		try {
			String path="c:/image/naver/";
			int list = image.lastIndexOf("/");
			String fileName = image.substring(list + 1);
			File file=new File(path + fileName);
			if(file.exists()) return;
			
			URL url=new URL(image);
			InputStream in=url.openStream();
			OutputStream out=new FileOutputStream(path + fileName);
			FileCopyUtils.copy(in, out);
		} catch (Exception e) {
			System.out.println("다운로드 오류" + e.toString());
		}
	}
	
}
