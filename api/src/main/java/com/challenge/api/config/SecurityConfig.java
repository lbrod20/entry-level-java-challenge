package com.challenge.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


/**
 * Security configuration for the application
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    /**
     * Configure security filter chain
     * @param http HttpSecurity instance
     * @return Configured SecurityFilterChain
     * @throws Exception in case of configuration errors
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    /**
     * Deprecated and not recommended for production use. Just for demonstration purposes of security.
     * 
     * In-memory user details service for authentication
     * @return UserDetailsService instance
     */
    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
        var user = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username("webhookUser")
                .password("webhookPass")
                .roles("WEBHOOK")
                .build();
        return new org.springframework.security.provisioning.InMemoryUserDetailsManager(user);
    }
}
