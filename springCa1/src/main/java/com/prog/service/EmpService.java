package com.prog.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.prog.entity.Employee;
import com.prog.repository.EmpRepo;


public class EmpService {

	
	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e) {
		
		repo.save(e);
	
	}	
}
