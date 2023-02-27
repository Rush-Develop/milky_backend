package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.formLogin(login -> {
            login
                .loginPage("/loginview")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login_ok")
                // .loginProcessingUrl("/api/login_ok") // rest api
                .defaultSuccessUrl("/index")
                .permitAll();
        });

        http
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/member/**").authenticated()
                        .antMatchers("/admnin/**", "/api/admin/**").access("hasRole('ROLE_ADMIN')")
                        .anyRequest().permitAll()
                );

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .deleteCookies("JSESSIONID");

        http.csrf().disable();

        return http.build();
    }
}
