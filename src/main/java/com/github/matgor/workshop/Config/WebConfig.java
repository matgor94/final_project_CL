package com.github.matgor.workshop.Config;

import com.github.matgor.workshop.Domain.Model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class WebConfig {
    @Bean(name = "localResolver")
    public LocaleContextResolver getLocalContextResolver(){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(new Locale("pl"));
        return sessionLocaleResolver;
    }
    @Bean(name = "user")
    public User user(){
        return new User();
    }
}
