/*
 * MoverController
 */
package com.e.labor.controller;

import com.e.labor.model.Mover;
import com.e.labor.service.MoverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    
    private final static Logger logger = LoggerFactory.getLogger(MoverController.class.getName());
    
    @Autowired
    private MoverService moverService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @RequestMapping(value = "/mover", method= RequestMethod.GET)
    public Mover get(@RequestParam String id){
        return moverService.get(id);
    }
    
    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public Mover login(@RequestParam String username, @RequestParam String password){
        return moverService.login(username, password);
    }
    
    @RequestMapping(value = "/mover", method= RequestMethod.DELETE)
    public void delete(String id){
        moverService.delete(id);
    }
    
    @RequestMapping(value = "/mover/id", method= RequestMethod.POST)
    public Mover save(Mover mover){
        return moverService.save(mover);
    }
    
    @RequestMapping(value = "/mover/query", method= RequestMethod.GET)
    public Mover query(Mover mover){
        return moverService.queryMover(mover);
    }
    
    
}
