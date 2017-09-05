/*
 * MovingJobRepository
 */
package com.e.labor.repository;

import com.e.labor.model.MovingJob;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jasonpalmer
 */
@Repository("movingJobRepository")
public interface MovingJobRepository extends MongoRepository<MovingJob, String>{
    
    List<MovingJob> findByMoverIds(List<String> usernames);
    
}
