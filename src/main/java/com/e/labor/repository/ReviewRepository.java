/*
 * ReviewRepository
 */
package com.e.labor.repository;

import com.e.labor.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jasonpalmer
 */
@Repository("reviewRepository")
public interface ReviewRepository extends MongoRepository<Review, String>{
    
}
