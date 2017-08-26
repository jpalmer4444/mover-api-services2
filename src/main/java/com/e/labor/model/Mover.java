/*
 * Mover
 * Models a Mover looking for work.
 */
package com.e.labor.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jasonpalmer
 */
public class Mover extends User {
    
    private int years;
    
    private int months;
    
    private List reviews;

    public Mover(String firstName, String lastName, String username, String password, Date memberSince, int years, int months, List<Review> reviews){
        super(firstName, lastName, username, password, memberSince);
        this.years = years;
        this.months = months;
        this.reviews = reviews;
    }
    
    public Mover() {
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.getUsername());
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
        final Mover other = (Mover) obj;
        if (this.getUsername().equals(other.getUsername())) {
            return false;
        }
        return true;
    }
    
    
    
}
