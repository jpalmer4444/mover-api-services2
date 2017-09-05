/*
 * GroupController
 */
package com.e.labor.controller;

import com.e.labor.json.GroupMoverRating;
import com.e.labor.model.Group;
import com.e.labor.service.GroupService;
import java.util.List;
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
public class GroupController {
    
    private final static String _BASE = "/group";
    
    @Autowired
    private GroupService groupService;
    
    @RequestMapping(value = _BASE,  method= RequestMethod.GET)
    public List<Group> getGroupsByMover(
            @RequestParam(name="mover") String mover, 
            @RequestParam(name="start") int start, 
            @RequestParam(name="end") int end
    ){
        
        return groupService.findByMover(mover);
        
    }
    
    @RequestMapping(value = _BASE + "/movers/ratings",  method= RequestMethod.GET)
    public List<GroupMoverRating> getGroupMoversRatingsByMover(@RequestParam(name="username") String username){
        
        return groupService.findGroupWithAll(username);
        
    }
    
}
