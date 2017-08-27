/*
 * MoverService
 */
package com.e.labor.service;

import com.e.labor.model.Group;
import com.e.labor.model.Mover;
import java.util.List;
import java.util.Set;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jasonpalmer
 */
public interface MoverService {
    
    Mover save(Mover mover);
    
    Mover register(Mover mover, String password);
    
    Mover get(String username);
    
    void delete(String username);
    
    Mover insert(Mover mover);
    
    Mover login(String username, String password);
    
    List<Mover>group(Group group);
    
    List<Mover>groupLikeName(String name, Pageable pageable);
    
    Mover queryMover(Mover mover);
    
}
