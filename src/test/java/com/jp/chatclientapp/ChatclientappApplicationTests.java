package com.jp.chatclientapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.profiles.active=ollamma"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class ChatclientappApplicationTests {

	@Autowired
	ChatClient.Builder builder;
	protected ChatClient chatClient;
    @BeforeAll
	public void setUp(){
     this.chatClient=this.builder.build();
	}

}
