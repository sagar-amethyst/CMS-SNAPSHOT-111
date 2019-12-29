package com.defteam.modal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.defteam.modal.User;
import com.defteam.modal.repo.UserRepository;
import com.defteam.modal.service.SecurityService;

@Controller
public class UserController {

	@Autowired
	private SecurityService  securityService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	 @RequestMapping(value = "/", method = RequestMethod.GET)	
	  public String showHome(ModelMap modeMap){
		 return "login/login";
	 	}
	
	@RequestMapping(value = "/showlogin", method = RequestMethod.GET)
	public String showLogin() {
		return "login/login";
	}

	@RequestMapping(value = "/showregistration", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String showRegisterPage() {
		return "/login/registerUser";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveClaim(@ModelAttribute("user") User user, ModelMap modelMap) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		System.out.println(userRepository);
		userRepository.save(user);
		return "login/login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {

		//User user = userRepository.findByEmail(email);
		
		boolean loginResponse=securityService.login(email, password);
		
		
		if (loginResponse) {
			return "redirect:displayClaimDetails";
		} else {

			modelMap.addAttribute("invalidMsg", "Invalid user and Password Try again..");
		}
		
		
	/*	if (user.getPassword().equals(password)) {
			return "redirect:displayClaimDetails";
		} else {

			modelMap.addAttribute("invalidMsg", "Invalid user and Password Try again..");
		}*/

		return "login/login";

	}

	@RequestMapping(value = "/displayClaimDetails", method = RequestMethod.GET)
	public String displayClaimDetails() {
		return "redirect:allClaims";
	}
	/*
	 * @RequestMapping(value = "/allClaims", method = RequestMethod.GET) public
	 * String allClaims() { return "redirect:allClaims"; }
	 */

}