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

	//������ ���� ����
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		sessions.remove(session);
		System.out.println("�������" + session.getId());
	}
	//������ ����
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
		sessions.add(session);
		System.out.println("�����" + session.getId());
	}

	//�޼����� ����
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String strMessage=message.getPayload(); SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); String strDate=sdf.format(new Date()); strMessage = strMessage + "|" + strDate; 
		 System.out.println("id: " + session.getId()+ " message: " + strMessage); //��� �������� �޼��� ���
		 for(WebSocketSession webSocketSession : sessions){
		 webSocketSession.sendMessage(new TextMessage(strMessage)); }
		super.handleTextMessage(session, message);
	}

}
