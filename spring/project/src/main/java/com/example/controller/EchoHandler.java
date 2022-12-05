package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{
	List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();

	//웹소켓 연결 끊김
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		sessions.remove(session);
		System.out.println("연결끊김" + session.getId());
	}
	//웹소켓 연결
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
		sessions.add(session);
		System.out.println("연결됨" + session.getId());
	}

	//메세지가 전송
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String strMessage=message.getPayload(); SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); String strDate=sdf.format(new Date()); strMessage = strMessage + "|" + strDate; 
		 System.out.println("id: " + session.getId()+ " message: " + strMessage); //모든 유저에게 메세지 출력
		 for(WebSocketSession webSocketSession : sessions){
		 webSocketSession.sendMessage(new TextMessage(strMessage)); }
		super.handleTextMessage(session, message);
	}

}
