package com.thigki.ntu._5.hanguyentienthinh_fitCMS.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;

import com.thigki.ntu._5.hanguyentienthinh_fitCMS.models.Page;
import com.thigki.ntu._5.hanguyentienthinh_fitCMS.models.Post;

@Controller
public class HomeControllers {
	
	ArrayList<Page> dsTrang = new ArrayList<Page>();
	ArrayList<Post> dsBaiViet = new ArrayList<Post>();
	
	
	public HomeControllers() {
		
		dsTrang.add(new Page(1, "Trang chủ", "home", "Nội dung trang chủ", 0));
		dsTrang.add(new Page(2, "Giới thiệu", "about", "Giới thiệu về CMS", 0));
		dsTrang.add(new Page(3, "Liên hệ", "contact", "Thông tin liên hệ", 0));
		
		
		dsBaiViet.add(new Post(1, "Học Spring Boot", "Nội dung bài học Spring Boot", 1, "spring.png"));
		dsBaiViet.add(new Post(2, "Lập trình Web", "Hướng dẫn làm web cơ bản", 1, "web.png"));
		dsBaiViet.add(new Post(3, "Kinh nghiệm IT", "Chia sẻ kinh nghiệm học tập", 2, "it.png"));
	}

	
	@GetMapping("/")
	public String home() {
		return "Index"; 
	}
		
	@GetMapping("/Bai2")
	public String bai2(Model model) { 
		
		model.addAttribute("dsTrang", dsTrang);
		model.addAttribute("dsBaiViet", dsBaiViet);
		
		return "Bai2"; 
	}
}