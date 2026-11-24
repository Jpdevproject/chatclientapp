package com.jp.chatclientapp.sec01;

import com.jp.chatclientapp.ChatclientappApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Lec02ChatStreamingTest extends ChatclientappApplicationTests {
    private static final String PROMPT="Write long paragraph on Indian culture";
    @Test
    public void chatSynchronousTest(){
        String response = this.chatClient.prompt(PROMPT)
                .call()
                .content();
        log.info("Synchronous:"+response);
    }

    @Test
    public void chatAsynchronousTest(){
        log.info("Asynchronous:");
         this.chatClient.prompt(PROMPT)
                .stream()
                .content()
                .doOnNext(System.out::println)
                .blockLast();

    }
}
