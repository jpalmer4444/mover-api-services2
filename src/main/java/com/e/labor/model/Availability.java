/*
 * Availability
 * Represents timeframe that Mover is Available to be
 * scheduled for a MovingJob.
 */
package com.e.labor.model;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jasonpalmer
 */
public class Availability {
    
    private final static Logger logger = LoggerFactory.getLogger(Availability.class.getName());
    
    private String id;
    
    private String moverId;
    
    private Date start;
    
    private Date end;

    public String getMoverId() {
        return moverId;
    }

    public void setMoverId(String moverId) {
        this.moverId = moverId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
