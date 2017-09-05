/*
 * BaseService
 */
package com.e.labor.service;

import com.e.labor.utility.OffsetBasedPageRequest;
import java.util.List;

/**
 *
 * @author jasonpalmer
 */
public interface MongoService<T> {
    
    T save(T entity);
    
    T get(String id);
    
    List<T>getAll(OffsetBasedPageRequest pageable);
    
    void delete(String id);
    
    T insert(T entity);
    
}
