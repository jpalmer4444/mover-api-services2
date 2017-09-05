/*
 * AvailabilityRepository
 */
package com.e.labor.repository;

import com.e.labor.model.Availability;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jasonpalmer
 */
@Repository("availabilityRepository")
public interface AvailabilityRepository extends MongoRepository<Availability, String>{
    
}
