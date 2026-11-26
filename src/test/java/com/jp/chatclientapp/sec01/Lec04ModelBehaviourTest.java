package com.jp.chatclientapp.sec01;

import com.jp.chatclientapp.ChatclientappApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.ai.chat.prompt.ChatOptions;

import java.util.stream.IntStream;

@Slf4j
public class Lec04ModelBehaviourTest extends ChatclientappApplicationTests {
    private static final String PROMPT = "Suggest me a name of my cofee shop. Return only one word ";

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    public void maxToken(int token) {

        executePrompt(PROMPT, ChatOptions.builder()
                .maxTokens(token));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.9, 1.2, 2.5})
    public void tempratureTest(double tempature) {
        IntStream.rangeClosed(1, 3).forEach(i -> executePrompt(PROMPT, ChatOptions.builder().temperature(tempature)));
    }

    private void executePrompt(String prompt, ChatOptions.Builder chatOptionsBuilder) {
        var response = this.chatClient
                .prompt(prompt)
                .options(chatOptionsBuilder)
                .call()
                // .content();
                .chatResponse();

        log.info("response :" + response);
    }
}
