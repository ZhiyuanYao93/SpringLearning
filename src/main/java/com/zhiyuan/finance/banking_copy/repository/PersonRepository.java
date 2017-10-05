package com.zhiyuan.finance.banking_copy.repository;

import org.springframework.data.repository.CrudRepository;

import com.zhiyuan.finance.banking_copy.model.PersonPersistence;

public interface PersonRepository extends CrudRepository<PersonPersistence,Integer> {
	
}
