/*
 * RoleRepository
 */
package com.e.labor.repository;

import com.e.labor.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jasonpalmer
 */
@Repository("roleRepository")
public interface RoleRepository extends MongoRepository<Role, String>{
    
}
