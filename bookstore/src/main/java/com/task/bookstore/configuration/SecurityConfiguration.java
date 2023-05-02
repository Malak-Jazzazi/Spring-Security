package com.task.bookstore.configuration;

import com.task.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .requestMatchers("/stores", "/stores/{id}").hasAnyRole("normalUser", "storeAdmin")
                .requestMatchers("/stores/{id}/books").hasRole("storeAdmin")
                .requestMatchers("/books", "/login" , "/h2-console").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout();

        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

    private String[] getAntMatchersForRole(String... roles) {
        // Logic to retrieve antMatchers for given roles from database
        List<String> antMatchersList = new ArrayList<>();
        antMatchersList.add("/stores");
        antMatchersList.add("/stores/{id}");
        if (Arrays.asList(roles).contains("roleUser")) {
            antMatchersList.add("/stores/{id}/books");
        }
        return antMatchersList.toArray(new String[0]);
    }
}
