package com.jp.chatclientapp.sec01;

import com.jp.chatclientapp.ChatclientappApplicationTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.ai.chat.client.AdvisorParams;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

public class MovieRecomenderSystemTest extends ChatclientappApplicationTests {
    @BeforeAll
    public void setup(){
        this.builder.defaultSystem("""
                        you are a movie recommender assistant.
                        
                        Rules:
                        1.Only provide well known movies.
                        2.Recommend only 3 movies
                        
                        """)
                .defaultUser("""
                        Suggest movies similar to {movieTitle}
                        Do not recommend the same {movieTitle} 
                        """)
                .build();
    }
    record Movie(String title,Double imdbRating,int releaseYear){}

    @ParameterizedTest
    @ValueSource(strings = {"Bhagam Bhag",
            "inception",
            "the good, the bad, the ugly"})
    public void recommendMovies(String movieTitle){
        List<Movie> movies = this.executeRecommendedMovies(movieTitle);
        movies.forEach(System.out::println);

    }

    private List<Movie> executeRecommendedMovies(String movieTitle) {
       return this.chatClient
                .prompt()
                .advisors(AdvisorParams.ENABLE_NATIVE_STRUCTURED_OUTPUT)
                .user(template->template.param("movieTitle",movieTitle))
                .call()
                .entity(new ParameterizedTypeReference<List<Movie>>() {
                });
    }
}
