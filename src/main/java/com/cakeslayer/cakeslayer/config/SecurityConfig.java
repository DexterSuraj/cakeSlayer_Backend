package com.cakeslayer.cakeslayer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for stateless REST APIs
                .csrf(csrf -> csrf.disable())

                // Stateless session management (no server-side sessions)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Define endpoint access rules
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").permitAll() // open endpoints
//                        .requestMatchers("/a/**").hasRole("ADMIN") // role-based auth
                        .anyRequest().authenticated() // everything else requires auth
                )

                // Use basic auth for simplicity (not recommended for production unless over HTTPS)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
