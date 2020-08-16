package com.isaccanedo.springbootwebsocketexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.isaccanedo.springbootwebsocketexample.model.UserResponse;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 3000)
    public void sendAdhocMessages() {
        template.convertAndSend("/topic/user", new UserResponse("Intervalo fixo de Delay em 3 segundos"));
    }
}
