/*
 * Rating
 * This class is not persistent it is derived from 
 * Review instances belonging to a particular mover.
 */
package com.e.labor.json;

import java.util.Objects;

public class Rating {
    
    private String username;
    
    private String rating;

    public Rating(String username, String rating) {
        this.username = username;
        this.rating = rating;
    }
    
    public Rating() {
    }
    
    public Rating(Rating cloneable) {
        this.username = cloneable.getUsername();
        this.rating = cloneable.getRating();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.username);
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
        final Rating other = (Rating) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
    
}
