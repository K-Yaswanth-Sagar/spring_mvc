package com.tw.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tw.entity.FoodMenu;
import com.tw.service.MenuService;


@Controller
public class MyController {

	@Autowired
	private MenuService ms;
	
	@GetMapping("/index")
    public String showMenuPage(Model model) {
        List<FoodMenu> menuList = ms.getMemu();
        model.addAttribute("menu", menuList);
        return "index";  
    }

	@GetMapping("/addMenu")
    public String showAddMenuForm(Model model) {
        model.addAttribute("foodMenu", new FoodMenu()); 
        return "add-menu"; 
    }

    @PostMapping("/addMenu")
    public String save(@ModelAttribute FoodMenu fm) {
        ms.saveMenu(fm);
        return "redirect:/index"; 
    }
	
	
	
}
