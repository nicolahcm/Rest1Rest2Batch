package it.generali.r1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class AppConfig {

        @Bean
        public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder)
        {
            return restTemplateBuilder
                    .setConnectTimeout(Duration.of(10000, ChronoUnit.MILLIS))
                    .setReadTimeout(Duration.of(10000,ChronoUnit.MILLIS))
                    .build();
        }
}