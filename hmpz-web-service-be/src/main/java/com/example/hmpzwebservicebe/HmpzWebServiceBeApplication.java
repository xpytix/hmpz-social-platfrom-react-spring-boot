package com.example.hmpzwebservicebe;

import com.example.hmpzwebservicebe.model.Post;
import com.example.hmpzwebservicebe.model.User;
import com.example.hmpzwebservicebe.repository.PostRepository;
import com.example.hmpzwebservicebe.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class HmpzWebServiceBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmpzWebServiceBeApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(PostRepository postRepository, UserRepository userRepository) {
        return args -> {
            User user = new User();
            user.setName("hejo");
            userRepository.save(user);

            Post post = new Post();
            post.setName("mem");
            post.setVoteCount(1213);
            postRepository.save(post);

            post.setUser(user);
            System.out.println(user);
        };
    }
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
