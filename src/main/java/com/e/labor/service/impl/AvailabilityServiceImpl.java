/*
 * AvailabilityServiceImpl
 */
package com.e.labor.service.impl;

import com.e.labor.model.Availability;
import com.e.labor.repository.AvailabilityRepository;
import com.e.labor.service.AvailabilityService;
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
@Service("availabilityService")
public class AvailabilityServiceImpl implements AvailabilityService {

    private final static Logger LOG = LoggerFactory.getLogger(AvailabilityServiceImpl.class.getName());

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Availability findByMoverId(String username) {
        Query myquery = query(where("moverId").is(username));
        return mongoOperations.findOne(myquery, Availability.class);
    }

    @Override
    public Availability save(Availability entity) {
        return availabilityRepository.save(entity);
    }

    @Override
    public Availability get(String id) {
        return availabilityRepository.findOne(id);
    }

    @Override
    public List<Availability> getAll(OffsetBasedPageRequest pageable) {
        return availabilityRepository.findAll(pageable).getContent();
    }

    @Override
    public void delete(String id) {
        availabilityRepository.delete(id);
    }

    @Override
    public Availability insert(Availability entity) {
        return availabilityRepository.insert(entity);
    }

}
