package com.thigki.ntu._5.hanguyentienthinh_fitCMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigki.ntu._5.hanguyentienthinh_fitCMS.models.Page;
import com.thigki.ntu._5.hanguyentienthinh_fitCMS.responsitory.PageRepository;

@Service
public class PageServices {
	@Autowired
	PageRepository pRepos;
	public List<Page> getAllPages() {
		return pRepos.findAll();
	}
	public Page getPageByID(int id) {
		return pRepos.getById(id);
	}
	
	

}
