package com.jp.chatclientapp.sec01;

import com.jp.chatclientapp.ChatclientappApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
@Slf4j
public class Lec01BasicChatTest extends ChatclientappApplicationTests {

    @Test
    public void basicChat(){
      var response=  this.chatClient.prompt("what is the capital of USA")
                .call()
                .content();
      log.info(response);
    }
}
