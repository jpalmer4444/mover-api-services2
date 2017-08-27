package com.e.labor;

import com.e.labor.model.Mover;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicApplicationTests {

    @Autowired
    private MongoOperations mongoOperations;

    @Test
    public void contextLoads() {

        Query query = new Query();
        query.addCriteria(Criteria.where("username").is("mover"));
        Mover mover = mongoOperations.findOne(query, Mover.class);
        Assert.assertTrue("Mongo is not plugged in or their are no documents in the Mover collection matching username = mover!", mover != null);

    }

}
