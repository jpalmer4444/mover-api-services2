/*
 * RoleServiceImpl
 */
package com.e.labor.service.impl;

import com.e.labor.model.Role;
import com.e.labor.repository.RoleRepository;
import com.e.labor.service.RoleService;
import com.e.labor.utility.OffsetBasedPageRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jasonpalmer
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
    
    @Override
    public Role insert(Role role) {
        return roleRepository.insert(role);
    }

    @Override
    public Role get(String role) {
        return roleRepository.findOne(role);
    }

    @Override
    public void delete(String role) {
        roleRepository.delete(role);
    }

    @Override
    public List<Role> getAll(OffsetBasedPageRequest pageable) {
        return roleRepository.findAll(pageable).getContent();
    }
    
}
