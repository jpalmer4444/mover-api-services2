/*
 * Group
 */
package com.e.labor.model;

import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;

/**
 *
 * @author jasonpalmer
 */
public class Group {
    
    private final static Logger logger = LoggerFactory.getLogger(Group.class.getName());
    
    @Id
    private String id;
    
    private String name;
    
    private String city;
    
    private String state;
    
    private List<String>moverIds;
    
    private String ownerId;

    public Group(String id, String name, String city, String state, List<String> moverIds, String ownerId) {
        this.ownerId = ownerId;
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.moverIds = moverIds;
    }
    
    public Group() {
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public List<String> getMoverIds() {
        return moverIds;
    }

    public void setMoverIds(List<String> moverIds) {
        this.moverIds = moverIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.city);
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
        final Group other = (Group) obj;
        return this.id.equals(other.id) && this.city.equals(other.city);
    }
    
    
    
}
