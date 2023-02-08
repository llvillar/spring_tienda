package com.llvillar.springboot.app1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.llvillar.springboot.app1.services.impl.UserService;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        // return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    UserService myUserService() {
        return new UserService();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                // .password(passwordEncoder().encode("kaka"))
                .password("{noop}kaka")
                .authorities("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                // .password(passwordEncoder().encode("kaka"))
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .authorities("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        // authProvider.setUserDetailsService(users());
        authProvider.setUserDetailsService(myUserService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    // @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //http.authenticationProvider(authenticationProvider());
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
            .and()
                .formLogin()
            .and()
                .httpBasic();

        return http.build();
    }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http.csrf()
    //             .disable()
    //             .authorizeRequests()
    //             .antMatchers("/admin/**")
    //             .hasRole("ADMIN")
    //             .antMatchers("/anonymous*")
    //             .anonymous()
    //             .antMatchers("/login*")
    //             .permitAll()
    //             .anyRequest()
    //             .authenticated()
    //             .and()
    //             .formLogin()
    //             .loginPage("/login")
    //             //.loginProcessingUrl("/perform_login")
    //             .defaultSuccessUrl("/welcome", true)
    //             .failureUrl("/login?error=true")
    //             //.failureHandler(authenticationFailureHandler())
    //             .and()
    //             .logout()
    //             //.logoutUrl("/perform_logout")
    //             .deleteCookies("JSESSIONID");
    //             //.logoutSuccessHandler(logoutSuccessHandler());
    //     return http.build();
    // }

}