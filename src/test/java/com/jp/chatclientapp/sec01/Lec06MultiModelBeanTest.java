package com.jp.chatclientapp.sec01;

import com.jp.chatclientapp.ChatclientappApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@Slf4j
public class Lec06MultiModelBeanTest  extends ChatclientappApplicationTests {
    @Autowired
    private  ChatClient proModel;
    @Autowired
    private  ChatClient liteModel;
    private String PROMPT="If 3 pencils cost $1.20, how much do 7 pencils cost? Return only the number";
    @Test
    public void modelVariantTest(){
        log.info("Pro model response");
        executePrompt(proModel,PROMPT);

        log.info("Lite model response");
        executePrompt(liteModel,PROMPT);

    }

    private void executePrompt(ChatClient chatClient, String prompt) {
        @Nullable String response = chatClient.prompt(prompt)
                .call().content();
        log.info("Chat client response :"+response);
    }
   @TestConfiguration
    static class TestBeanConfig{

        @Bean
        public ChatClient proModel(ChatClient.Builder builder){
            return this.creatClient(builder,"gemma3:270m");

        }

        @Bean
        public ChatClient liteModel(ChatClient.Builder builder){
            return this.creatClient(builder,"llama3.2");
        }

        private ChatClient creatClient(ChatClient.Builder builder, String model) {
            return builder.defaultOptions(ChatOptions.builder()
                    .model(model)
                            .maxTokens(10)
                            .temperature(0.3))
                    .build();
        }
    }
}
