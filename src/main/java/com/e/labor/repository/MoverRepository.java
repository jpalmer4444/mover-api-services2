/*
 * MoverRepository
 */
package com.e.labor.repository;

import com.e.labor.model.Group;
import com.e.labor.model.Mover;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jasonpalmer
 */
@Repository("moverRepository")
public interface MoverRepository extends MongoRepository<Mover, String> {

    Mover findByUsername(String username);

}
