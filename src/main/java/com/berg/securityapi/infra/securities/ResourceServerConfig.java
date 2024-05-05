package com.berg.securityapi.infra.securities;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ResourceServerConfig  {

    private final KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter;
    
    @SuppressWarnings("removal")
    @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                . authorizeHttpRequests(authz -> authz.requestMatchers("/security/**").authenticated())
                . oauth2ResourceServer(server -> server
                        .jwt().jwtAuthenticationConverter(keycloakJwtAuthenticationConverter));
       return http.build();
   }

    // @Override
    // public void configure(final HttpSecurity http) throws Exception {
    //     http
    //             .authorizeRequests(authz -> authz.requestMatchers("/security/**").authenticated())
    //             .oauth2ResourceServer()
    //             .jwt().jwtAuthenticationConverter(keycloakJwtAuthenticationConverter);
    // }
}