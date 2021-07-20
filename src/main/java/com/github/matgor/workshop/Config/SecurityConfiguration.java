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
                //TODO Ta konfiguracja nie wydaję się być poprawna :)
                .antMatchers("/user/edit","/user/delete",
                        "/vehicle/add", "/vehicle/edit", "/vehicle/delete"
                        ).hasAnyRole("ADMIN", "USER", "EMPLOYEE")
                .antMatchers(  "/task/add", "/task/delete", "/task/edit").hasAnyRole("ADMIN", "USER")
                .antMatchers("/vehicle/all", "/user/all", "/task/all", "/repair/all").hasRole("ADMIN")
                .antMatchers("/repair/all", "/repair/add", "/repair/delete", "/repair/edit").hasAnyRole("ADMIN", "EMPLOYEE")
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
