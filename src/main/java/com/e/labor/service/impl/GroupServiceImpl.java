/*
 * GroupServiceImpl
 */
package com.e.labor.service.impl;

import com.e.labor.json.GroupMoverRating;
import com.e.labor.json.Rating;
import com.e.labor.model.Group;
import com.e.labor.model.Mover;
import com.e.labor.repository.GroupRepository;
import com.e.labor.service.GroupService;
import com.e.labor.service.ReviewService;
import com.e.labor.utility.OffsetBasedPageRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.stereotype.Service;

/**
 *
 * @author jasonpalmer
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService, InitializingBean {

    private final static Logger LOG = LoggerFactory.getLogger(GroupServiceImpl.class.getName());

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group get(String id) {
        Group group = groupRepository.findOne(id);
        LOG.info(String.format("get(%s) Found group %s", id, group != null ? group.getName() : "NONE"));
        return group;
    }

    @Override
    public Group findByName(String name) {
        Group group = groupRepository.findByName(name);
        LOG.info(String.format("findByName(%s) found: %s", name, group != null ? group.getName() : "NONE"));
        return group;
    }

    @Override
    public void delete(String id) {
        LOG.info(String.format("Deleting group with ID %s", id));
        groupRepository.delete(id);
    }

    @Override
    public Group insert(Group group) {
        LOG.info(String.format("Inserting group with name: %s", group != null ? group.getName() : "null"));
        return groupRepository.insert(group);
    }

    @Override
    public List<Group> getAll(OffsetBasedPageRequest pageable) {
        List<Group> groups = groupRepository.findAll(pageable).getContent();
        LOG.info(String.format("getAll returned %s groups.", groups.size()));
        return groups;
    }

    @Override
    public List<Group> findByMover(String username) {
        List<String> moverIds = new ArrayList<>();
        moverIds.add(username);
        Query myquery = query(where("moverIds").in(moverIds));
        List<Group> groups = mongoOperations.find(myquery, Group.class);
        LOG.info(String.format("Group size: %s", groups != null ? groups.size() : 0));
        return groups;
    }

    /**
     * Find Group Movers and Ratings for each
     *
     * @param username
     * @return GroupMoverRating wrapper class encapsulating all movers along
     * with their ratings for each group
     */
    @Override
    public List<GroupMoverRating> findGroupWithAll(String username) {
        List<GroupMoverRating> groupMoverRatings = new ArrayList<>();
        List<Group> groups = findByMover(username);
        groups.forEach((group) -> {
            GroupMoverRating gmr = new GroupMoverRating();
            gmr.setGroup(group);
            List<String> moverIds = group.getMoverIds();
            Query myquery = query(where("username").in(moverIds));
            List<Mover> moversInGroup = mongoOperations.find(myquery, Mover.class);
            Set<Rating> ratings = new HashSet<>();
            moversInGroup.stream().map((mover) -> reviewService.getRatingForMover(mover.getUsername())).
                    forEachOrdered((rating) -> {
                        if (rating != null) {
                            ratings.add(rating);
                        }
                    });
            gmr.setMovers(new HashSet<>(moversInGroup));
            gmr.setRatings(ratings);
            groupMoverRatings.add(gmr);

        });
        return groupMoverRatings;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

}
