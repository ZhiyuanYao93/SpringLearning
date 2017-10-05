package com.zhiyuan.finance.banking_copy.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhiyuan.finance.banking_copy.model.PersonPersistence;
import com.zhiyuan.finance.banking_copy.model.User;
import com.zhiyuan.finance.banking_copy.service.UserService;
/**
 * 
 * @author zhiyuanyao
 *
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
//	setter-based injection
//	@Autowired
	private UserService userService;
	
//	constructor based injection
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	 
	@RequestMapping("/name")
//	public List<User> fetchName() {
//		List<User> userList = new ArrayList<User>();
//		User obj = new User();
//		obj.setName("Zhiyuan");
//		obj.setCity("Fremont");
//		obj.setAge(24);
//		userList.add(obj);
//		
//		User obj2 = new User();
//		obj2.setName("Michael");
//		obj2.setCity("San Jose");
//		obj2.setAge(99);
//		userList.add(obj2);
//		
//		return userList;
//	}
	public List<PersonPersistence> fetchAllPerson(){
		return userService.findAllPerson();
	}
	
	@RequestMapping("/name/{id}")
//	public String fetchNameByUserId(@PathVariable(value="id") int userId) {
//		return "Zhiyuan" + userId;
//	}
	public PersonPersistence fetchByUserId(@PathVariable(value="id") int userId) {
		return userService.findById(userId);
	}
	
	
	@RequestMapping("/nameparam")
	public String fetchNameByParam(@RequestParam(value="id") int userId) {
		return "Data: " + userId;
	}
	
	@RequestMapping("/address")
	public String fetchAddress(@RequestParam(value="id") int userId,
							   @RequestHeader(value="token") String auth) {
		System.out.println("Got token: " + auth);
		return "Validated: " + userId;
	}
	
	@RequestMapping(value="/name",method=RequestMethod.POST)
	public User createUser(@RequestBody User userObj) {
		
		System.out.println("name: " + userObj.getName());
		System.out.println("age: " + userObj.getAge());
		System.out.println("city: " + userObj.getCity());
		
		log.info("name: {}",userObj.getName());
		log.debug("age: {}",userObj.getAge());
		log.info("city: {}",userObj.getCity());
		
		return userService.createUser(userObj);
	}
	
	@RequestMapping(value="/name/delete/{id}",method=RequestMethod.POST)
	public boolean deleteById(@PathVariable(value="id") int id) {
		return userService.deletePersonById(id);
	}
	
	
	@RequestMapping(value="/name/deleteall",method=RequestMethod.POST)
	public boolean deleteAll() {
		return userService.deleteAll();
	}
	
}
