/*
 * Availability
 * Represents timeframe that Mover is Available to be
 * scheduled for a MovingJob.
 */
package com.e.labor.model;

import java.util.Date;

/**
 *
 * @author jasonpalmer
 */
public class Availability {
    
    private String id;
    
    private Mover mover;
    
    private Date start;
    
    private Date end;

    public Mover getMover() {
        return mover;
    }

    public void setMover(Mover mover) {
        this.mover = mover;
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
