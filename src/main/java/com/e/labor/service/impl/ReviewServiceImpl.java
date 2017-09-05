/*
 * ReviewServiceImpl
 */
package com.e.labor.service.impl;

import com.e.labor.model.MovingJob;
import com.e.labor.json.Rating;
import com.e.labor.model.Review;
import com.e.labor.model.Stars;
import com.e.labor.repository.ReviewRepository;
import com.e.labor.service.MovingJobService;
import com.e.labor.service.ReviewService;
import com.e.labor.utility.OffsetBasedPageRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author jasonpalmer
 */
@Service("reviewService")
public class ReviewServiceImpl implements ReviewService, InitializingBean {

    private final static Logger LOG = LoggerFactory.getLogger(ReviewServiceImpl.class.getName());

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovingJobService movingJobService;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Review> findByAboutId(String username) {
        Query myquery = query(where("aboutId").is(username));
        return mongoOperations.find(myquery, Review.class);
    }

    @Override
    public List<Review> findByAuthorId(String username) {
        Query myquery = query(where("authorId").is(username));
        return mongoOperations.find(myquery, Review.class);
    }

    @Override
    public Review save(Review entity) {
        return reviewRepository.save(entity);
    }

    @Override
    public Review get(String id) {
        return reviewRepository.findOne(id);
    }

    @Override
    public List<Review> getAll(OffsetBasedPageRequest pageable) {
        return reviewRepository.findAll(pageable).getContent();
    }

    @Override
    public void delete(String id) {
        reviewRepository.delete(id);
    }

    @Override
    public Review insert(Review entity) {
        return reviewRepository.insert(entity);
    }

    @Override
    public Rating getRatingForMover(String username) {
        Aggregation agg = newAggregation(
                match(where("aboutId").is(username)),
                group("aboutId").last("aboutId").as("username").avg("stars").as("rating"),
                project("username", "rating")
                .and("stars").previousOperation()
        );
        AggregationResults<Rating> results = mongoOperations.aggregate(agg, "review", Rating.class);
        return results.getUniqueMappedResult();
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        //
    }

}
