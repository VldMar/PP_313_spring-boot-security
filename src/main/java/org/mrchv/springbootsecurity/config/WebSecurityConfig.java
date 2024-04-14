package org.mrchv.springbootsecurity.config;

import org.mrchv.springbootsecurity.model.User;
import org.mrchv.springbootsecurity.repository.UserRepository;
import org.mrchv.springbootsecurity.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService getUserDetailsService(UserService userService) {
        return username -> {
            User user = userService.findByUserName(username);
            if (user == null) {
                throw new UsernameNotFoundException("Пользователь " + user.getUsername() + " не найден");
            }

            return user;
        };
    }

    @Bean
    public SecurityFilterChain setFilterChain(HttpSecurity http) throws Exception {
        return http
                .build();
    }
}
