package com.example.demoDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demoDB.model.DatabaseSequence;

@Service
public class SequenceGeneratorService {
	@Autowired private MongoOperations mongoOperations;
	
	@Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long generateSequence(String seqName) {

    	Query query = new Query(Criteria.where("_id").is(seqName));
    	Update update = new Update().inc("seq", 1);
    	DatabaseSequence counter = mongoOperations.findAndModify(query, update, DatabaseSequence.class); // return old Counter object
    	return counter.getSeq();	

    }
}

