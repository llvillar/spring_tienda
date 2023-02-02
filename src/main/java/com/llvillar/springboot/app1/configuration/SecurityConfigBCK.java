// package com.llvillar.springboot.app1.configuration;


// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;


// @Configuration
// @EnableWebSecurity
// public class SecurityConfigBCK extends WebSecurityConfigurerAdapter {

//     // @Bean
//     // public BCryptPasswordEncoder passwordEncoder(){
//     //     return new BCryptPasswordEncoder();
//     // }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//            return NoOpPasswordEncoder.getInstance();
//     }

//     @Override
//     public void configure(AuthenticationManagerBuilder auth) throws Exception{
//       auth.inMemoryAuthentication()
//         .withUser("user")
//             .password("{noop}1234").roles("USER")
//             .and()
//         .withUser("admin")
//             .password("{noop}4321").roles("USER", "ADMIN");
//     }

//     public void configure(HttpSecurity http) throws Exception{
//         http
//         .authorizeRequests()
//         .anyRequest()
//         .authenticated()
//         .and()
//         .httpBasic();
//     }
// }
