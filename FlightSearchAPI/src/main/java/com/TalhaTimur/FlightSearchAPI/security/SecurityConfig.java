package com.TalhaTimur.FlightSearchAPI.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/**")) // CSRF sadece belirli endpointler için devre dışı
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").authenticated() // Swagger'a erişim için login gerekli
                        .anyRequest().authenticated() // Diğer tüm istekler için de login zorunlu
                )
                .formLogin(withDefaults()) // Varsayılan login sayfası
                .logout(logout -> logout
                        .logoutUrl("/logout") // Çıkış işlemi için varsayılan URL
                        .logoutSuccessUrl("/login?logout")); // Çıkış başarılı olduğunda yönlendirilme

        return http.build();
    }
}