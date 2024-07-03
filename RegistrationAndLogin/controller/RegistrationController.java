package com.Registration.RegistrationAndLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Registration.RegistrationAndLogin.entity.Employee;
import com.Registration.RegistrationAndLogin.repo.EmployeeRepository;
@Controller
public class RegistrationController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "registration";
    }
	@PostMapping("/registration")
    public String processRegistrationForm(@ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/login";
    }
}
