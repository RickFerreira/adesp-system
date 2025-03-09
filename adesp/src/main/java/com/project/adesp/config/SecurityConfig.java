package com.project.adesp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                //.requestMatchers("/api/public/**").permitAll()  // Permite acesso público sem autenticação
                                .anyRequest().permitAll()  // Exige autenticação para outras rotas
                );

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//    }

}
