/*
 * MovingJobServiceImpl
 */
package com.e.labor.service.impl;

import com.e.labor.model.MovingJob;
import com.e.labor.model.Review;
import com.e.labor.repository.MovingJobRepository;
import com.e.labor.repository.ReviewRepository;
import com.e.labor.service.MovingJobService;
import com.e.labor.utility.OffsetBasedPageRequest;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.stereotype.Service;

/**
 *
 * @author jasonpalmer
 */
@Service("movingJobService")
public class MovingJobServiceImpl implements MovingJobService {
    
    private final static Logger LOG = LoggerFactory.getLogger(MovingJobServiceImpl.class.getName());
    
    @Autowired
    private MovingJobRepository movingJobRepository;
    
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public MovingJob findByDriverId(String username) {
        Query myquery = query(where("driverId").is(username));
        return mongoOperations.findOne(myquery, MovingJob.class);
    }

    @Override
    public MovingJob save(MovingJob entity) {
        return movingJobRepository.save(entity);
    }

    @Override
    public MovingJob get(String id) {
        return movingJobRepository.findOne(id);
    }

    @Override
    public List<MovingJob> getAll(OffsetBasedPageRequest pageable) {
        return movingJobRepository.findAll(pageable).getContent();
    }

    @Override
    public void delete(String id) {
        movingJobRepository.delete(id);
    }

    @Override
    public MovingJob insert(MovingJob entity) {
        return movingJobRepository.insert(entity);
    }
    
    @Override
    public List<MovingJob> findByMoverIds(List<String> usernames){
        return movingJobRepository.findByMoverIds(usernames);
    }
    
}
