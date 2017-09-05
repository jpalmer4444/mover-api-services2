/*
 * ReviewController
 */
package com.e.labor.controller;

import com.e.labor.json.Rating;
import com.e.labor.model.Review;
import com.e.labor.service.ReviewService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jasonpalmer
 */
@RestController
public class ReviewController {
    
    private final static Logger LOG = LoggerFactory.getLogger(ReviewController.class.getName());
    
    private final static String _BASE = "/review";
    
    @Autowired
    private ReviewService reviewService;
    
    @RequestMapping(value = _BASE, method= RequestMethod.GET)
    public Review get(@RequestParam String id){
        return reviewService.get(id);
    }
    
    @RequestMapping(value = _BASE + "/mover", method= RequestMethod.GET)
    public List<Review> getReviewsByMover(@RequestParam(name="username") String username,
            @RequestParam(name="start") int start, 
            @RequestParam(name="end") int end){
        return reviewService.findByAboutId(username);
    }
    
    @RequestMapping(value = _BASE + "/rating", method= RequestMethod.GET)
    public Rating getRatingForMover(@RequestParam(name="username") String username){
        return reviewService.getRatingForMover(username);
    }
    
}
