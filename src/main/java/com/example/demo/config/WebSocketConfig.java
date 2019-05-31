package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //client에서 webSocket을 연결할 api를 설정
        //최초 socket연결을 하는경우 endpoint가 되는 url, 추후 javacript에서 SockJS생성자를 통해 연결
        registry.addEndpoint("/websocket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); //client로 메시지를 응답해줄 때의 prefix를 정의
        registry.setApplicationDestinationPrefixes("/app"); //client에서 메시지 송신시의 prefix를 정의
    }
}
