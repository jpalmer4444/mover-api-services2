/*
 * ReviewService
 */
package com.e.labor.service;

import com.e.labor.json.Rating;
import com.e.labor.model.Review;
import java.util.List;

/**
 *
 * @author jasonpalmer
 */
public interface ReviewService extends MongoService<Review> {
    
    List<Review> findByAboutId(String username);
    
    List<Review> findByAuthorId(String username);
    
    Rating getRatingForMover(String username);
    
}
