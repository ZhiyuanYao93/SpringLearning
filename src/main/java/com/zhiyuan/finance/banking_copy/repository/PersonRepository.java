package com.zhiyuan.finance.banking_copy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zhiyuan.finance.banking_copy.model.PersonPersistence;
/**
 * 
 * @author zhiyuanyao
 *
 */
public interface PersonRepository extends CrudRepository<PersonPersistence,Integer> {
	public List<PersonPersistence> findByFullNameAndAge(String name,int age);
	//public List<PersonPersistence> findByFullNameIgnoreCase()	
}
