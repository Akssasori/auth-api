package com.lucas.auth.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // para requisição post no /product precisa ser admin para a outras só preciso que ele seja autenticado
                // ou seja agora tudo vai estar fechado ate que a gente autentique
                .authorizeHttpRequests( authorize -> authorize.requestMatchers(HttpMethod.POST,"/product").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .build();
    }
}
