/*
 * WebSecurityConfig
 */
package com.e.labor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author jasonpalmer
 */
@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    
    
    private final static Logger LOG = LoggerFactory.getLogger(WebSecurityConfig.class.getName());

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
          .antMatchers("/login*").anonymous().anyRequest().fullyAuthenticated().and().
                httpBasic().and().
                csrf().disable();
    }

}
