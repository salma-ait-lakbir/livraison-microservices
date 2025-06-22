package com.livraison.commande.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {
        http
                .securityMatcher(new AntPathRequestMatcher("/**")) // permet de sécuriser tous les endpoints
                .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll()) // autorise toutes les requêtes
                .csrf(AbstractHttpConfigurer::disable); // désactive CSRF

        return http.build();
    }
}