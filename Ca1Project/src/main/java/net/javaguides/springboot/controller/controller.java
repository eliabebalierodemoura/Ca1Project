package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.Chicago_data_crime;
import net.javaguides.springboot.service.DataService;

@Controller
public class controller {

	@Autowired
	private DataService data_Service;
	
	//This is our login  we put as index page
	@RequestMapping(value="/", method = RequestMethod .GET)
    
	public String loginPage() {
	
	return"index";
}

@RequestMapping(value="/", method = RequestMethod .POST)
public String welcome(Model model, String userID, @RequestParam String password ) {

if(userID.equalsIgnoreCase("CCT") && password.equals("12345") ) {

return "home";


} 
return "index";
}

	
	// display list of our data
	@GetMapping("/home")
	public String viewHomePage(Model model) {
		return findPaginated(1, "crimeID", "asc", model);		
	}
	
	@GetMapping("/showDataForm")
	public String dataForm(Model model) {
		// create model attribute to bind form data
		Chicago_data_crime data = new Chicago_data_crime();
		model.addAttribute("data", data);
		return "new_data";
	}
	
	@PostMapping("/saveData")
	public String saveData(@ModelAttribute("data") Chicago_data_crime data) {
		/*save data to database, you need to create a data base called chicago and then
		 * a table called "chicago_data_crimes" will be loaded
		*/
		data_Service.saveChicago_data(data);
		return "redirect:/home";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get data from the service
		Chicago_data_crime data = data_Service.getChicago_dataById(id);
		
		// set data as a model attribute to pre-populate the form
		model.addAttribute("data", data);
		return "update_data";
	}
	
	@GetMapping("/deleteData/{id}")
	public String deleteData(@PathVariable (value = "id") long id) {
		
		// call delete data method 
		this.data_Service.deleteChicago_dataById(id);
		return "redirect:/home";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Chicago_data_crime> page = data_Service.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Chicago_data_crime> listData = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listData", listData);
		return "home";
	}
}
