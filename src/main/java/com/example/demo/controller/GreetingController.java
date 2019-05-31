package com.example.demo.controller;

import com.example.demo.domain.Chat;
import com.example.demo.domain.Greeting;
import com.example.demo.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello") // client에서 /hello로 메시지를 전달하면 해당 함수가 실행됨
    @SendTo("/topic/greetings") // 함수의 결과를 설정된 url쪽으로 return시킴
    public Greeting greeting(HelloMessage message) throws Exception{
        //Thread.sleep(1000);
        return new Greeting("Hello, "+ HtmlUtils.htmlEscape(message.getName()) +"!");
    }

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public Chat chat(Chat chat) throws Exception {
        return new Chat(chat.getName(), chat.getMessage());
    }
}
