package com.jp.chatclientapp.sec01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootTest(properties = {"spring.ai.ollama.chat.options.model=gemma3:270m",
        "spring.ai.ollama.base-url=http://localhost:11434", "spring.ai.google.genai.api-key=${GEMINI_API_KEY}", "spring.ai.openai.api-key=${OPENAI_API_KEY}"
        , "spring.ai.google.genai.chat.options.model=gemini-3.5-flash-lite"
})
public class Lec07MultiModelProviderTest {
    @Autowired
    private ChatClient ollamaClient;

    @Autowired
    private ChatClient geminiClient;

    @Autowired
    private ChatClient openAiClient;
    @Test
    public void multiModelProviderTest(){
        String prompt="What is java";
        this.executePromt(ollamaClient,"ollama",prompt);
        this.executePromt(geminiClient,"gemini",prompt);
       // this.executePromt(openAiClient,"openai",prompt);
    }

    private void executePromt(ChatClient chatClient, String clientName, String prompt) {
        var response=chatClient.prompt(prompt).call().content();

        log.info("{} => {}", clientName, response);
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public ChatClient ollamaClient(OllamaChatModel ollamaChatModel) {
            return ChatClient.create(ollamaChatModel);
        }

        @Bean
        public ChatClient geminiClient(GoogleGenAiChatModel googleGenAiChatModel) {
            return ChatClient.create(googleGenAiChatModel);
        }

        @Bean
        public ChatClient openAiClient(OpenAiChatModel openAiChatModel) {
            return ChatClient.create(openAiChatModel);
        }
    }
}
