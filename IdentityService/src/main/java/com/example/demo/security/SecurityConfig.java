package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration 
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/auth/**").permitAll()
                    
                    .requestMatchers("/users/**").hasRole("ADMINISTRATOR")
                    
                    .requestMatchers("/api/notifications/**").hasRole("ADMINISTRATOR")
                    
                    .requestMatchers("/dispense/**").hasRole("PHARMACIST")
                    
                    .requestMatchers("/recall/**").hasRole("COMPLIANCE_OFFICER")
                    
                    .requestMatchers("/consumpLog/**").hasRole("COMPLIANCE_OFFICER")
                    
                    .requestMatchers("/returns/**").hasRole("PHARMACIST")
                    
                    .requestMatchers("/goodsreceipts/**").hasRole("PROCUREMENT_OFFICER")
                    
                    .requestMatchers("/products/**").hasRole("ADMINISTRATOR")
                    
                    .requestMatchers("/batches/**").hasRole("PHARMACIST")
                    
                    .requestMatchers("/purchaseorders/**").hasRole("PROCUREMENT_OFFICER")
                    
                    .requestMatchers("/suppliers/**").hasRole("PROCUREMENT_OFFICER")
                    
                    .requestMatchers("/audit/**").hasRole("AUDITOR")
                    
                    .requestMatchers("/expiryalerts/**").hasRole("COMPLIANCE_OFFICER")
                    
                    .requestMatchers("/kpi/**").hasRole("ADMINISTRATOR")
                    
                    .requestMatchers("/reports/**").hasRole("COMPLIANCE_OFFICER")
                    
                    .requestMatchers("/quarantine/**").hasRole("PHARMACIST")
                    
                    .requestMatchers("/stockcount/**").hasRole("STOREKEEPER")
                    
                    .requestMatchers("/reconciliation/**").hasRole("STOREKEEPER")
                    
                    .requestMatchers("/api/alert-rules/**").hasRole("ADMINISTRATOR")
                    
                    .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}