package com.ks.accountapp;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface AccountRepository extends MongoRepository<Account, String> {
    Account findBy_id(ObjectId _id);

}
