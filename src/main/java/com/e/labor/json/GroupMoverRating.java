/*
 * GroupMoverRating
 * Wraps Groups with the Mover within that group along with each Movers Rating.
 */
package com.e.labor.json;

import com.e.labor.model.Group;
import com.e.labor.model.Mover;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.annotation.Transient;

/**
 *
 * @author jasonpalmer
 */
public class GroupMoverRating {

    private Group group;

    private Set<Mover> movers;

    private Set<Rating> ratings;

    public GroupMoverRating(Group group, Set<Mover> movers, Set<Rating> ratings) {
        this.group = group;
        this.movers = movers;
        this.ratings = ratings;
    }
    
    public GroupMoverRating() {
        
    }

    public static Mover lookupMover(String username, Collection<Mover> movers) {
        Optional<Mover> firstElement = movers.stream().
                filter(rating -> rating.getUsername().equals(username)).
                findAny();
        return firstElement.orElse(null);
    }
    
    public static Rating lookupRating(String username, Collection<Rating> ratings) {
        Optional<Rating> firstElement = ratings.stream().
                filter(rating -> rating.getUsername().equals(username)).
                findAny();
        return firstElement.orElse(null);
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setMovers(Set<Mover> movers) {
        this.movers = movers;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }
    
    public Group getGroup() {
        return group;
    }

    public Set<Mover> getMovers() {
        return movers;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }
}
