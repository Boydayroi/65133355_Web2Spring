package com.thigki.ntu._5.hanguyentienthinh_fitCMS.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.thigki.ntu._5.hanguyentienthinh_fitCMS.models.Page;

import com.thigki.ntu._5.hanguyentienthinh_fitCMS.services.PageServices;


@RestController
public class RestAPIController {
	@Autowired
	PageServices pservices;
	
	
	@GetMapping("/restAPI/pages/all")
	public List<Page> getAllPages() {
		List<Page> dsTrang = new ArrayList<Page>();
		//dsTrang.add(new Page(0, "ten trang","tu khoa","noi dung", 0));
		dsTrang = pservices.getAllPages();
		return dsTrang;
	}
	@GetMapping("/restAPI/pages/{id}")
	public Page getPage(@PathVariable("id")int id) {
		return pservices.getPageByID(id);
	}
	
}	
