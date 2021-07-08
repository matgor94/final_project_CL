package com.github.matgor.workshop.Config;

import com.github.matgor.workshop.Domain.Service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final CustomUserDetailsService customUserDetailsService;
    public SecurityConfiguration(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

   @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/addUser").permitAll()
                .antMatchers("/user/addEmployee").permitAll()
                .antMatchers("/user/addAdmin").permitAll()
                .antMatchers("/registartion").permitAll()
                .antMatchers("login").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/user/edit", "/user/delete", "/user/all",
                        "/vehicle/add", "/vehicle/edit", "/vehicle/delete", "/vehicle/all",
                        "/task/add", "/task/all", "/task/edit", "/task/delete",
                        "/repair/add", "/repair/all", "/repair/edit", "/repair/delete").hasRole("ADMIN")
                .antMatchers("/user/edit", "/user/delete",
                "/vehicle/add", "/vehicle/edit", "/vehicle/delete",
                "/task/add", "/task/edit", "/task/delete").hasRole("USER")
                .antMatchers(  "/vehicle/add", "/vehicle/edit", "/vehicle/delete", "/vehicle/all",
                        "/task/add", "/task/all", "/task/edit", "/task/delete",
                        "/repair/add", "/repair/all", "/repair/edit", "/repair/delete").hasRole("EMPLOYEE")
                .antMatchers("/*").permitAll()
                .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .defaultSuccessUrl("/task/all")
                    .and()
                .csrf()
                    .disable();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
