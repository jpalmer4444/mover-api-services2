/*
 * MoverServiceImpl
 */
package com.e.labor.service.impl;

import com.e.labor.model.Group;
import com.e.labor.model.Mover;
import com.e.labor.repository.MoverRepository;
import com.e.labor.service.MoverService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
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
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Mover save(Mover mover) {
        return moverRepository.save(mover);
    }
    
    @Override
    public Mover register(Mover mover, String password) {
        
        //add Roles
        
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
    public Mover login(String username, String password){
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        Mover mover = mongoOperations.findOne(query, Mover.class);
        if (passwordEncoder.matches(password, mover.getPassword())) {
            return mover;
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        
    }
}
