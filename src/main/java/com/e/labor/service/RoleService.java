/*
 * RoleService
 */
package com.e.labor.service;

import com.e.labor.model.Role;

/**
 *
 * @author jasonpalmer
 */
public interface RoleService {
    
    Role save(Role role);
    
    Role get(String role);
    
    void delete(String role);
    
}
