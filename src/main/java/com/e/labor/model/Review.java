/*
 * Review
 */
package com.e.labor.model;

import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jasonpalmer
 */
public class Review {
    
    private final static Logger logger = LoggerFactory.getLogger(Review.class.getName());
    
    private long id;
    
    private short stars;
    
    private String comment;
    
    private String aboutId;
    
    private String authorId;
    
    private MovingJob movingJob;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public short getStars() {
        return stars;
    }

    public void setStars(short stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAboutId() {
        return aboutId;
    }

    public void setAboutId(String aboutId) {
        this.aboutId = aboutId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public MovingJob getMovingJob() {
        return movingJob;
    }

    public void setMovingJob(MovingJob movingJob) {
        this.movingJob = movingJob;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.aboutId);
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
        final Review other = (Review) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
