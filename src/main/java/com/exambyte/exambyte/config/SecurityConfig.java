package com.exambyte.exambyte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {
        chainBuilder.authorizeHttpRequests(
                    configurer -> configurer
                            .requestMatchers("/css/*").permitAll()
                            .requestMatchers("/correction").hasRole("Korrektor")
                            .requestMatchers("/test-management", "/results", "/correction-status").hasRole("Organisator")
                            .anyRequest().authenticated()
            ).oauth2Login(config ->
                config.userInfoEndpoint(
                        info -> info.userService(new CustomOAuth2UserService())
                ));
        return chainBuilder.build();
    }
}
