/*
 * MoverService
 */
package com.e.labor.service;

import com.e.labor.utility.OffsetBasedPageRequest;
import com.e.labor.model.Group;
import com.e.labor.model.Mover;
import java.util.List;

/**
 *
 * @author jasonpalmer
 */
public interface MoverService extends MongoService<Mover> {
    
    Mover register(Mover mover, String password);
    
    Mover login(String username, String password);
    
    List<Mover>group(Group group, OffsetBasedPageRequest pageable);
    
    List<Mover>groupLikeName(String name, OffsetBasedPageRequest pageable);
    
    Mover queryMover(Mover mover);
    
}
