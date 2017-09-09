/*
 * RestConfig for CORS
 */
package com.e.labor;

import javax.servlet.Filter;
import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfig {
    
    @Value("${debug}")
    private boolean DEBUG;
    
    @Bean
    public FilterRegistrationBean requestDumperFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        Filter requestDumperFilter = new RequestDumperFilter();
        registration.setFilter(requestDumperFilter);
        registration.addUrlPatterns(DEBUG ? "/*": "/nourlunlessyouactuallyrouteditthisway");
        return registration;
    }
    
    

}
