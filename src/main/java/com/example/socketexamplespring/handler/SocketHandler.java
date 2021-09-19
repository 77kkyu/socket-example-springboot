package com.example.socketexamplespring.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;

@Slf4j
@Component
public class SocketHandler extends TextWebSocketHandler {

	HashMap<String, WebSocketSession> sessionMap = new HashMap<>();

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info("handleTextMessage start");
		String content = message.getPayload();
		log.info("content = " + content);
		for (String key : sessionMap.keySet()) {
			WebSocketSession webSocketSession = sessionMap.get(key);
			try {
				webSocketSession.sendMessage(new TextMessage(content));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("afterConnectionEstablished start");
		log.info("session = " + session.getId());
		super.afterConnectionEstablished(session);
		sessionMap.put(session.getId(), session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception { // 연결 종료
		log.info("afterConnectionClosed");
		sessionMap.remove(session.getId());
		super.afterConnectionClosed(session, status);
	}
}
