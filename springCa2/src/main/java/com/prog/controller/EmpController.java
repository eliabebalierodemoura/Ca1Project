package com.prog.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Employee;
import com.prog.service.EmpService;



@Controller
public class EmpController {

	@Autowired
	private EmpService service;
	
	
	@GetMapping("/index")
public String home(Model m) {
List<Employee> emp=service.getAllEmp();
m.addAttribute("emp", emp);	
	
		 return"index";
		 }
	
@GetMapping("/addemp")
	public String addEmpform(){

		return "add.emp";
	}
	
     @PostMapping("/register")
     public String empRegister(@ModelAttribute Employee e,HttpSession  session)
 	
 	{
     	 System.out.println(e);    	 
     	 service.addEmp(e);
     	session.setAttribute("msg", "Data added successfuly..");
     	 return "redirect:/";
 		
     	 
    	 
	
     
    
     }
    
	
}
