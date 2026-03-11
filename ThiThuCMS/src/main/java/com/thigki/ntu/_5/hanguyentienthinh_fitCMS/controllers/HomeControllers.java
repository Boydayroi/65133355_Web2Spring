package com.thigki.ntu._5.hanguyentienthinh_fitCMS.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeControllers {
	@GetMapping("/")
	public String home() {
		return "Index";
	}
}

