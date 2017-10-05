package com.zhiyuan.finance.banking_copy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyuan.finance.banking_copy.model.PersonPersistence;
import com.zhiyuan.finance.banking_copy.repository.PersonRepository;


@Controller
public class indexController {
	PersonRepository personRepository;
	
	@Autowired
	public indexController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@RequestMapping({"","/"})
	public String getIndex(Model model) {
		 model.addAttribute("records",personRepository.findAll());
		return "index";
	}
}
