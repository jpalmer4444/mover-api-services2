/*
 * MoverServiceImpl
 */
package com.e.labor.service.impl;

import com.e.labor.model.Group;
import com.e.labor.model.Mover;
import com.e.labor.repository.GroupRepository;
import com.e.labor.repository.MoverRepository;
import com.e.labor.service.CypherService;
import com.e.labor.service.MoverService;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author jasonpalmer
 */
@Service("moverService")
public class MoverServiceImpl implements MoverService, InitializingBean {

    private final static Logger LOG = LoggerFactory.getLogger(MoverServiceImpl.class.getName());

    @Autowired
    private MoverRepository moverRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    CypherService cypherService;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Mover save(Mover mover) {
        return moverRepository.save(mover);
    }
    
    @Override
    public Mover register(Mover mover, String password) {
        mover.setPassword(passwordEncoder.encode(password));
        return moverRepository.save(mover);
    }

    @Override
    public Mover get(String id) {
        return moverRepository.findOne(id);
    }

    @Override
    public void delete(String id) {
        moverRepository.delete(id);
    }

    @Override
    public Mover insert(Mover mover) {
        return moverRepository.insert(mover);
    }

    @Override
    public List<Mover> group(Group group) {
        List<String> moverIds = group.getMoverIds();
        Query myquery = query(where("id").in(moverIds));
        return mongoOperations.find(myquery, Mover.class);
    }

    @Override
    public List<Mover> groupLikeName(String name, Pageable pageable) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(name));
        Group group = mongoOperations.findOne(query, Group.class);
        List<String> moverIds = group.getMoverIds();
        Query myquery = query(where("id").in(moverIds));
        return mongoOperations.find(myquery, Mover.class);
    }

    @Override
    public Mover queryMover(Mover mover) {
        return moverRepository.findOne(Example.of(mover));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            String username = "mover";
            String password = "Password1";
            Mover mover = new Mover();
            mover.setUsername(username);
            mover.setPassword(passwordEncoder.encode(password));
            Group group = new Group();
            group.setName("John Group 1");
            group.setCity("Chicago");
            group.setState("IL");
            mover.setFirstName("John");
            mover.setLastName("Mover");
            mover.setMemberSince(new Date());
            mover.setMonths(1);
            mover.setYears(1);
            Mover preexisting = get(username);
            if (preexisting == null) {
                LOG.info("Inserting mover John Mover.");
                register(mover, mover.getPassword());
            } else {
                LOG.info(String.format("Found mover %s %s Mover - not inserting obviously.",
                        preexisting.getFirstName(), preexisting.getLastName()));
            }
        } catch (Exception ex) {
            LOG.error("Exception Occurred!", ex);
        }
    }
}
