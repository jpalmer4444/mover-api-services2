/*
 * GroupService
 */
package com.e.labor.service;

import com.e.labor.json.GroupMoverRating;
import com.e.labor.model.Group;
import java.util.List;

/**
 *
 * @author jasonpalmer
 */
public interface GroupService extends MongoService<Group> {
    
    Group findByName(String name);
    
    List<Group> findByMover(String username);
    
    List<GroupMoverRating>findGroupWithAll(String username);
    
}
