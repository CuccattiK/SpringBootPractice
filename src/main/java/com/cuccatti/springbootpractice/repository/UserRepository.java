package com.cuccatti.springbootpractice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cuccatti.springbootpractice.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	
}
