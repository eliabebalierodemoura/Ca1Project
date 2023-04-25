package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Employee;

public interface EmpRepo extends JpaRepository <Employee, Integer>{
	
	

}
