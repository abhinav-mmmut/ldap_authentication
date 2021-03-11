package com.example.ldap_authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping(value = "/login")
	public String login() {
		return "signin";
	}

	@RequestMapping(value = "/home")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/")
	public String home1() {
		return "index";
	}
}