package com.example.testbackendbank.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Отключаем CSRF для простоты, но не в production!
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/auth/**").permitAll() // Разрешить доступ ко всем запросам на /auth/**
                        .requestMatchers("/demo-controller").hasRole("USER") // Доступ только для пользователей с ролью USER
                        .anyRequest().authenticated() // Все остальные запросы требуют аутентификации
                )
                .authenticationProvider(authenticationProvider) // Настраиваем провайдер аутентификации
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // Добавляем JWT фильтр

        return http.build();
    }
}


