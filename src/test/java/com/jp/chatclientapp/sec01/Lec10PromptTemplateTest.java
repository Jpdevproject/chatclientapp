package com.jp.chatclientapp.sec01;

import com.jp.chatclientapp.ChatclientappApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Slf4j
public class Lec10PromptTemplateTest extends ChatclientappApplicationTests {

    @BeforeAll
    public void setup(){
        this.builder.defaultUser("Write a reply to a customer about {issue}. Keep the tone {tone}.")
                .defaultSystem("You are a customer support assistant. Limit responses to 2 sentences.")
                .build();
    }
    @ParameterizedTest
    @CsvSource({
            "delayed delivery, apologetic",
            "wrong item received, reassuring",
            "refund not processed, professional",
            "account locked, empathetic"
    })
    public void customerSupportRepyTest(String issue,String tone){
        log.info("issue: {}, tone: {}", issue, tone);
       String response= this.executeUserPrompt(issue,tone);
       log.info(response);
    }

    private @Nullable String executeUserPrompt(String issue, String tone) {
        return this.chatClient.prompt()
                .user(template->
                    template.param("issue",issue)
                            .param("tone",tone)
                )
                .call()
                .content();

    }
}
