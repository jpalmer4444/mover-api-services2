/*
 * Role
 */
package com.e.labor.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;

/**
 *
 * @author jasonpalmer
 */
public class Role {
    
    private final static Logger logger = LoggerFactory.getLogger(Role.class.getName());
    
    @Id
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
