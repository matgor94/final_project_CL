package com.github.matgor.workshop.Config;

import com.github.matgor.workshop.Domain.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


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
                .antMatchers("/").permitAll()
                .antMatchers("/user/addUser").permitAll()
                .antMatchers("/user/addEmployee").permitAll()
//                .antMatchers("/user/addAdmin").permitAll() nie ma sensu
                .antMatchers("/registartion").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/reset_password").permitAll()
                .antMatchers("/reset_password/**").permitAll()
                .antMatchers("/webapp/**").permitAll().antMatchers("/resources/static/css**", "/resources/static/js/**").permitAll()
                .antMatchers("/employee").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/user/edit", "/user/delete", "/vehicle/add", "/vehicle/edit", "/vehicle/delete").hasAnyRole("ADMIN", "USER", "EMPLOYEE")
                .antMatchers("/task/add", "/task/delete", "/task/edit", "/vehicle/all").hasAnyRole("ADMIN", "USER")
                .antMatchers( "/user/all", "/repair/all").hasRole("ADMIN")
                .antMatchers("/repair/all", "/repair/add", "/repair/delete", "/repair/edit").hasAnyRole("ADMIN", "EMPLOYEE")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/task/all")
                    .permitAll()
                    .and()
                .logout()
                    .logoutSuccessUrl("/login")
                    .and()
                .csrf()
                    .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/static/**");
    }

}
