/*
 * GroupRepository
 */
package com.e.labor.repository;

import com.e.labor.model.Group;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jasonpalmer
 */
@Repository("groupRepository")
public interface GroupRepository extends MongoRepository<Group, String> {

    public Group findByName(String name);
    
    List<Group> findByMoverIds(List<String> usernames);

}
