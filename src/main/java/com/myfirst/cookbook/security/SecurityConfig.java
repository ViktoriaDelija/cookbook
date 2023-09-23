package com.myfirst.cookbook.security;

import com.myfirst.cookbook.security.service.UserDetailsCustomService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CorsFilter;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Component
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsCustomService userDetailsCustomService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CorsFilter corsFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers(antMatcher("/api/ingredients/new")).hasRole("ADMIN")
                                .requestMatchers(antMatcher("/api/ingredients/delete/{ingId}")).hasRole("ADMIN")
                                .requestMatchers(antMatcher("/api/ingredients/edit/{ingId}")).hasRole("ADMIN")
                                .requestMatchers(antMatcher("/api/recipes/new")).hasAnyRole("ADMIN", "USER")
                                .requestMatchers(antMatcher("/api/recipes/delete/{recId}")).hasAnyRole("ADMIN", "USER")
                                .requestMatchers(antMatcher("/api/recipes/edit/{recId}")).hasAnyRole("ADMIN", "USER")
                                .requestMatchers(antMatcher("/api/login")).permitAll()
                                .requestMatchers(antMatcher("/api/signup")).permitAll()
                                .requestMatchers(antMatcher("/api/ingredients")).permitAll()
                                .requestMatchers(antMatcher("/api/ingredients/{ingId}")).permitAll()
                                .requestMatchers(antMatcher("/api/recipes")).permitAll()
                                .requestMatchers(antMatcher("/api/recipes/{recId}")).permitAll()
                                .requestMatchers(antMatcher("/h2-console")).permitAll())
                .csrf(csrf -> csrf.disable()).addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .headers(header -> header.frameOptions(frameOption -> frameOption.disable()))
                .httpBasic(httpBasic -> httpBasic.init(http))
                .build();
    }

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsCustomService);

        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

