package com.app.controller;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// dependancy:Serveice layer i/f
	@Autowired
	private IUserService userService;

	public UserController() {
		System.out.println("in ctor of" + getClass());
	}

// add request handling method for showing login from
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("IN show Login Form");
		return "/user/login";// WEB_INF/views/user/login.jsp
	}

	// add request handling method for processing loging form
	@PostMapping("login")
	// @RequestParam : anno for binding req param ---> method arg
	// String email=request.getparameter("email")
	// String pass=request.getparameter("password")
	public String processLoginForm(@RequestParam String email, @RequestParam(name = "password") String pass,Model map) {
		System.out.println("in process login form" + email + "" + pass+" "+map);
		try {
			// Controller has to invoke service layer method

			User AuthenticatedUser = userService.authenticateUser(email, pass);
			map.addAttribute("mesg","Successful Login....");
			//proceed to to role based autherization
			// Check user logged in in admin role==forward to /admin/status
			if(AuthenticatedUser.getRoles().contains(new Role(UserRole.ADMIN)))
				return "/admin/status";
			// Check user logged in in customer role==forward to /customer/topic
			if(AuthenticatedUser.getRoles().contains(new Role(UserRole.CUSTOMER)))
				return "/customer/topic";
			
			
			//+> Valid Login
			//Add validated User details under suitable scope  n forward client to success Page.jsp
			map.addAttribute("user_dtls",AuthenticatedUser);
			return "/user/Success";//AVN :/WEB-INF/views/user/success.jsp
			
		} catch (Exception e) {
			System.out.println("err in " + getClass() + " " + e);// no Exception
			//add error message in the Model ASttr map 
			map.addAttribute("mesg","Invalid Login,please retry....");
			return "/user/login";//in case of invalid login forward client to login.jsp
			//in same request
		}
		
	}

}
