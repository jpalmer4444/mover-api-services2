/*
 * AvailabilityService
 */
package com.e.labor.service;

import com.e.labor.model.Availability;

/**
 *
 * @author jasonpalmer
 */
public interface AvailabilityService extends MongoService<Availability> {
    
    Availability findByMoverId(String username);
    
}
