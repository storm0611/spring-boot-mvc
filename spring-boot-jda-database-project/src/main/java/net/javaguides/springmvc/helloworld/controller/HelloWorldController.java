package net.javaguides.springmvc.helloworld.controller;

import java.time.LocalDateTime;
import java.util.List;
import net.javaguides.springmvc.helloworld.exception.ResourceNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springmvc.helloworld.model.HelloWorld;
import net.javaguides.springmvc.helloworld.sevice.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Ramesh Fadatare
 */
@Controller
@RequestMapping("/employee")
public class HelloWorldController {
    
	@Autowired
	private HelloWorldService service;
	
	@GetMapping("/list")
	public String listHelloWorlds(Model theModel) {
		List<HelloWorld> thEmployees = service.getAllEmployees();
		theModel.addAttribute("employees", thEmployees);
		return "list-customers";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		HelloWorld thEmployee = new HelloWorld();
		theModel.addAttribute("employee", thEmployee);
		return "customer-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") HelloWorld thEmployee) {
		service.saveEmployee(thEmployee);	
		return "redirect:/employee/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) throws ResourceNotFoundException {
		HelloWorld thEmployee = service.getEmployee(theId);
		theModel.addAttribute("employee", thEmployee);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) throws ResourceNotFoundException {
		service.deleteEmployee(theId);
		return "redirect:/employee/list";
	}
}