package com.Registration.RegistrationAndLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Registration.RegistrationAndLogin.entity.Employee;
import com.Registration.RegistrationAndLogin.repo.EmployeeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "login";
    }
	
	@PostMapping("/login")
    public String login(@ModelAttribute("employee") Employee employee, HttpSession session) {
		Employee loggedInUser = employeeRepository.findByLoginIdAndPassword(employee.getLoginId(), employee.getPassword());
        if (loggedInUser != null) {
            session.setAttribute("user", loggedInUser);
            return "redirect:/welcome";
        } else {
            // Handle invalid login (e.g., display error message)
            return "login";
        }
    }
	
	@GetMapping("/welcome")
	public String welcomePage(  HttpSession session,Model model) {
		 Employee loggedInUser = (Employee) session.getAttribute("user");
		    if (loggedInUser != null) {
		        model.addAttribute("employeeName", loggedInUser.getName());
		    }
		    return "welcome";
		 
	}
	
}
