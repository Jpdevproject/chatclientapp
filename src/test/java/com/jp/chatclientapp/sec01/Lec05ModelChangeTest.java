package com.jp.chatclientapp.sec01;

import com.jp.chatclientapp.ChatclientappApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.ai.chat.prompt.ChatOptions;

@Slf4j
public class Lec05ModelChangeTest  extends ChatclientappApplicationTests {
    //llama3.2
    private static final String PROMPT="If 3 pencils cost $1.20, how much do 7 pencils cost? Return only the number";

    @ParameterizedTest
    @ValueSource(strings = {"gemma3:270m", "llama3.2"})
    public void modelChangeTest(String model){
        @Nullable String response = this.chatClient.prompt(PROMPT)
                .options(ChatOptions.builder().model(model))
                .call()
                .content();
        log.info(response);
    }
}
