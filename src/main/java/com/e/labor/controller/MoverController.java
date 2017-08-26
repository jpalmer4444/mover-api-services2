/*
 * MoverController
 */
package com.e.labor.controller;

import com.e.labor.model.Mover;
import com.e.labor.service.MoverService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jasonpalmer
 */
@RestController
public class MoverController {
    
    private MoverService moverService;
    
    @RequestMapping(value = "/mover", method= RequestMethod.GET)
    public Mover get(String id){
        return moverService.get(id);
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
