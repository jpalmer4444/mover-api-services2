/*
 * MovingJobService
 */
package com.e.labor.service;

import com.e.labor.model.MovingJob;
import java.util.List;

/**
 *
 * @author jasonpalmer
 */
public interface MovingJobService extends MongoService<MovingJob> {
    
    MovingJob findByDriverId(String username);
    
    List<MovingJob> findByMoverIds(List<String> usernames);
    
}
