package com.tw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.entity.FoodMenu;
import com.tw.repo.MenuRepo;

@Service
public class MenuService {

	@Autowired
	private MenuRepo repo;
	
	public void saveMenu(FoodMenu fm) {
		repo.save(fm);
	}
	
	public List<FoodMenu> getMemu(){
		return repo.findAll(); 
	}
	
}
