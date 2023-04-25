package com.prog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.prog.entity.Employee;

@Controller
public class EmpController {

	
	@GetMapping("/")
	 public String home() 
		{
	
	 return"index";
	 }
		
@GetMapping("/addemp")
	public String addEmpform(){

		return "add.emp";
	}
	
     @PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e)
	
	{
    	 System.out.println(e);
    	 
    	 return "add.emp";
		
	}
	
}
