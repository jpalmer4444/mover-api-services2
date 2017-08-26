/*
 * Review
 */
package com.e.labor.model;

import java.util.Objects;

/**
 *
 * @author jasonpalmer
 */
public class Review {
    
    private long id;
    
    private short stars;
    
    private String comment;
    
    private User about;
    
    private User author;
    
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

    public User getAbout() {
        return about;
    }

    public void setAbout(User about) {
        this.about = about;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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
        hash = 41 * hash + Objects.hashCode(this.about);
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
