//package com.assignment.Indegene.websecurity;
//
//import com.assignment.Indegene.exceptions.ChannelNotFoundException;
//import com.assignment.Indegene.exceptions.CustomExceptionHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public UserDetailsService userConfig(PasswordEncoder encoder){
//        UserDetails user= User.builder().username("Admin").
//                password(encoder.encode("Welcome@321"))
//                .roles("Admin").build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .authorizeHttpRequests().antMatchers("/swagger-ui/**","/v3/api-docs/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic(withDefaults());
//        return http.build();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//}
