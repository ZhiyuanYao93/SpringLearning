package com.zhiyuan.finance.banking_copy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyuan.finance.banking_copy.model.PersonPersistence;
//import com.zhiyuan.finance.banking_copy.controller.UserController;
import com.zhiyuan.finance.banking_copy.model.User;
import com.zhiyuan.finance.banking_copy.repository.PersonRepository;
/**
 * 
 * @author zhiyuanyao
 *
 */
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
	
	public PersonPersistence findById(int personId) {
		log.info("Fetching data for{} ",personId);
		if (personRepository.findOne(personId) == null) {
			throw new RuntimeException("Person Id not found");
		}
		PersonPersistence person = personRepository.findOne(personId);
		return person;
	}
	
	public List<PersonPersistence> findAllPerson(){
		log.info("Fetching all person records");
		return (List<PersonPersistence>) personRepository.findAll();
	}
	
	public boolean deletePersonById(int personId) {
		log.info("Trying to delete person with id: {}",personId);
		if (personRepository.findOne(personId) == null) {
			throw new RuntimeException("Person Id not found");
		}
		personRepository.delete(personId);
		return (personRepository.findOne(personId) == null);
	}
	
	public boolean deleteAll() {
		log.info("Deleting all records");
		personRepository.deleteAll();
		return ((List<PersonPersistence>)personRepository.findAll()).size() == 0;
	}
		
	
}
