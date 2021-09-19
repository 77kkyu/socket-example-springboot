package com.example.socketexamplespring.config;

import com.example.socketexamplespring.handler.SocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Autowired
	private SocketHandler socketHandler;

	/**
	 *
	 * <pre>
	 * @Date : 2021-09-17
	 * @author "윤철규(hash)"
	 * @History :
	 * @Description : cors설정 Websocket에 접속하기 위한 도메인 설정 ex) ws//localhost.../chating
	 * </pre>
	 *
	 * @return
	 */
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(socketHandler, "/chating");
	}

}
