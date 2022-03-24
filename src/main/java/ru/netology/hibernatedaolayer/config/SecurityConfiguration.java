package ru.netology.hibernatedaolayer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("vasiliy")
                .password(encoder.encode("vasiliy"))
                .roles("READ")
                .and()
                .withUser("admin")
                .password(encoder.encode("admin"))
                .roles("READ", "WRITE", "DELETE")
                .and()
                .withUser("evgeniy")
                .password(encoder.encode("evgeniy"))
                .roles("READ", "DELETE");
    }
}

