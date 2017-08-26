/*
 * MovingJob
 * Represents a scheduled Move at a specific point in time.
 */
package com.e.labor.model;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author jasonpalmer
 */
public class MovingJob {
    
    private long id;
    
    private int pounds;
    
    private int squareFeet;
    
    private Date start;
    
    private Date end;
    
    private Mover driver;
    
    private Set<Mover> movers;

    public MovingJob() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPounds() {
        return pounds;
    }

    public void setPounds(int pounds) {
        this.pounds = pounds;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
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

    public Mover getDriver() {
        return driver;
    }

    public void setDriver(Mover driver) {
        this.driver = driver;
    }

    public Set<Mover> getMovers() {
        return movers;
    }

    public void setMovers(Set<Mover> movers) {
        this.movers = movers;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.driver);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovingJob other = (MovingJob) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
