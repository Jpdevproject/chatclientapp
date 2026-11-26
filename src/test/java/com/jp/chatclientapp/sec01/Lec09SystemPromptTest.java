package com.jp.chatclientapp.sec01;

import com.jp.chatclientapp.ChatclientappApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
@Slf4j
public class Lec09SystemPromptTest extends ChatclientappApplicationTests {
    @ParameterizedTest
    @ValueSource(strings = {
            "You are a physics teacher. Answer briefly.",
            "You are a sound engineer. Answer briefly.",
            "You are a finance expert. Answer briefly."
    })
    public void multipleDomainResponseTest(String systemInformation){
        var prompt="What is volume ?";
      String response=this.executePrompt(systemInformation,prompt);
      log.info(response);

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "You are a sarcastic math teacher.",
            "You are a helpful math teacher."
    })
    public void toneBasedResponses(String systemInstruction) {
        @Nullable String response = this.executePrompt(systemInstruction, "What is square root of 100?");
        log.info(response);

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "You are a helpful assistant. Answer in one word.",
            "You are a helpful assistant. Answer in one sentence."
    })
    public void responseConstraints(String systemInstruction){

        @Nullable String response = this.executePrompt(systemInstruction, "Explain Java");
        log.info(response);

    }


    private @Nullable String executePrompt(String systemInformation, String prompt) {
       return this.chatClient.prompt(prompt)
                .system(systemInformation)
                .call()
                .content();
    }
}
