/*
 * MoverController
 */
package com.e.labor.controller;

import com.e.labor.model.Mover;
import com.e.labor.service.MoverService;
import com.e.labor.utility.OffsetBasedPageRequest;
import java.util.List;
import javax.annotation.security.RolesAllowed;
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
public class MoverController {
    
    private final static Logger LOG = LoggerFactory.getLogger(MoverController.class.getName());
    
    private final static String _BASE = "/mover";
    
    @Autowired
    private MoverService moverService;
    
    @RequestMapping(value = _BASE, method= RequestMethod.GET)
    public Mover get(@RequestParam String id){
        
        return moverService.get(id);
        
    }
    
    @RequestMapping(value = _BASE + "/login", method= RequestMethod.GET)
    public Mover login(@RequestParam String username, @RequestParam String password){
        
        return moverService.login(username, password);
        
    }
    
    @RequestMapping(value = _BASE + "/register", method= RequestMethod.POST)
    public Mover register(
            @RequestParam("mover") Mover mover
    ){
        
        return moverService.register(mover, mover.getPassword());
        
    }
    
    @RequestMapping(value = _BASE + "/delete", method= RequestMethod.DELETE)
    public void delete(String id){
        
        moverService.delete(id);
        
    }
    
    @RequestMapping(value = _BASE + "/group",  method= RequestMethod.GET)
    public List<Mover> getMoversByGroup(
            @RequestParam(name="group") String group, 
            @RequestParam(name="start") int start, 
            @RequestParam(name="end") int end
    ){
        
        OffsetBasedPageRequest pageable = new OffsetBasedPageRequest(start, end);
        return moverService.groupLikeName(group, pageable);
        
    }
    
    @RequestMapping(value = _BASE + "/id", method= RequestMethod.POST)
    public Mover save(Mover mover){
        
        return moverService.save(mover);
        
    }
    
    @RequestMapping(value = _BASE + "/query", method= RequestMethod.GET)
    public Mover query(Mover mover){
        
        return moverService.queryMover(mover);
        
    }
    
}