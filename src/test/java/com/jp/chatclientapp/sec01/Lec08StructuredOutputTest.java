package com.jp.chatclientapp.sec01;

import com.jp.chatclientapp.ChatclientappApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.AdvisorParams;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@Slf4j
public class Lec08StructuredOutputTest extends ChatclientappApplicationTests {

    record Book(String title,String author,int publishedYear){}
    @Test
    public void mapToEntityTest(){
        var prompt = """
                Extract book details from the below text.
                
                Sam published a book on Java Programming in 2016.
                He also released another book on Python Programming, 3 years later.
                That same year Mike released a book on Reactive Programming.
                """;
       var books= executePrompt(prompt)
               .entity(new ParameterizedTypeReference<List<Book>>() {
               });
       books.forEach(System.out::println);
    }

    private ChatClient.CallResponseSpec executePrompt(String prompt){
       return this.chatClient
                .prompt(prompt)
                .advisors(AdvisorParams.ENABLE_NATIVE_STRUCTURED_OUTPUT)
                .call();
    }
}
