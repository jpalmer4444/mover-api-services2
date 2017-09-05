/*
 * MovingJobController
 */
package com.e.labor.controller;

import com.e.labor.model.Mover;
import com.e.labor.model.MovingJob;
import com.e.labor.service.MovingJobService;
import java.util.ArrayList;
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
public class MovingJobController {
    
    private final static Logger LOG = LoggerFactory.getLogger(MovingJobController.class.getName());
    
    private final static String _BASE = "/movingjob";
    
    @Autowired
    private MovingJobService movingJobService;
    
    @RequestMapping(value = _BASE, method= RequestMethod.GET)
    public MovingJob get(@RequestParam String id){
        return movingJobService.get(id);
    }
    
    @RequestMapping(value = _BASE + "/mover", method= RequestMethod.GET)
    public List<MovingJob> getByMoverId(@RequestParam(name="username") String username){
        List<String>usernames = new ArrayList<>();
        usernames.add(username);
        return movingJobService.findByMoverIds(usernames);
        
    }
    
}
