package com.jp.chatclientapp.sec01;

import com.jp.chatclientapp.ChatclientappApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatResponse;

@Slf4j
public class Lec03ChatResponseTest extends ChatclientappApplicationTests {
    private static final String PROMPT="what is Richardson maturity model";
    @Test
    public void chatResponseTest(){
        @Nullable ChatResponse response = this.chatClient.prompt(PROMPT)
                .call()
                .chatResponse();
       // log.info(String.valueOf(response.getMetadata()));
      //  log.info(String.valueOf(response.getResult()));
        log.info(String.valueOf(response));
        log.info(String.valueOf(response.getMetadata().getRateLimit().getRequestsLimit()));
    }
}
