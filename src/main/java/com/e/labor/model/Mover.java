/*
 * Mover
 * Models a Mover looking for work.
 */
package com.e.labor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;

/**
 *
 * @author jasonpalmer
 */
public class Mover {
    
    private final static Logger LOG = LoggerFactory.getLogger(Mover.class.getName());
    
    private String firstName;
    
    private String lastName;
    
    @Id
    private String username;
    
    @JsonIgnore
    private String password;
    
    private Date memberSince;
    
    private int years;
    
    private int months;
    
    private List<String> reviewIds;
    
    private List<String> roles;

    public Mover(String firstName, String lastName, String username, String password, Date memberSince, int years, int months, List<String> reviewIds, List<String> roles){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.memberSince = memberSince;
        this.years = years;
        this.months = months;
        this.reviewIds = reviewIds;
        this.roles = roles;
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

    public List<String> getReviewIds() {
        return reviewIds;
    }

    public void setReviews(List<String> reviewIds) {
        this.reviewIds = reviewIds;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
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
