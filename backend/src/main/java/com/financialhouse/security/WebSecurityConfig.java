package com.financialhouse.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.savedrequest.NullRequestCache;

/**
 * @author Sinan
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.headers()
                .and().cors().disable().csrf().disable().requestCache().requestCache(new NullRequestCache())
                .and().httpBasic()
                .and().authorizeRequests().anyRequest().permitAll()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
    }
}

