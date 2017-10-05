package com.zhiyuan.finance.banking_copy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyuan.finance.banking_copy.model.PersonPersistence;
//import com.zhiyuan.finance.banking_copy.controller.UserController;
import com.zhiyuan.finance.banking_copy.model.User;
import com.zhiyuan.finance.banking_copy.repository.PersonRepository;

@Service
public class UserService {
	Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	PersonRepository personRepository;
	
	public User createUser(User user) {
//		System.out.println("Received request to create: " + user.getName());
//		log.info("Received request to create: {}",user.getName());
		//TODO: Invoke DAO class
//		user.setUserId(1);
		log.info("Saving data for {}",user.getName());
		
		PersonPersistence personPersistence = new PersonPersistence();
		personPersistence.setAge(user.getAge());
		personPersistence.setCity(user.getCity());
		personPersistence.setFullName(user.getName());
		
		PersonPersistence p = personRepository.save(personPersistence);
		user.setUserId(p.getPersonId());
		return user;	
	}
}
