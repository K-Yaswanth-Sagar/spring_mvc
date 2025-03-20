package com.tw.service;

import java.util.List;
import java.util.Optional;

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
	
	public FoodMenu getMenuById(Long id) {
	    return repo.findById(id).orElse(null);
	}
	
	public boolean updateMenu(FoodMenu foodMenu) {
	    Optional<FoodMenu> existingMenu = repo.findById(foodMenu.getId());
	    if (existingMenu.isPresent()) {
	        repo.save(foodMenu); 
	        return true;
	    }
	    return false;
	}
	
	public boolean deleteMenu(Long id) {
	    if (repo.existsById(id)) {
	        repo.deleteById(id);
	        return true;
	    }
	    return false;
	}


	
}
