package com.tw.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tw.entity.FoodMenu;
import com.tw.service.MenuService;


@Controller
public class MyController {

	@Autowired
	private MenuService ms;
	
	@GetMapping("/food-menu")
    public ModelAndView showMenuPage() {
		ModelAndView mv = new ModelAndView();
        List<FoodMenu> menuList = ms.getMemu();
        mv.addObject("menus", menuList);
        mv.setViewName("food-menu");
        return mv;
    }

	@GetMapping("/add-menu")
    public ModelAndView showAddMenuForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("newItem", new FoodMenu());
		mv.setViewName("add-menu");
		return mv;
    }

    @PostMapping("/add-menu")
    public ModelAndView save(@ModelAttribute FoodMenu fm) {
    	ms.saveMenu(fm);
    	ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/add-menu");
        return mv; 
    }
    
    @GetMapping("/edit-menu/{id}")
    public ModelAndView showEditMenuForm(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("edit-menu");
        FoodMenu foodMenu = ms.getMenuById(id); 
        mv.addObject("foodMenu", foodMenu);
        return mv;
    }

    @PostMapping("/update-menu")
    public String updateMenu(@ModelAttribute FoodMenu foodMenu) {
        ms.updateMenu(foodMenu); 
        
        return "redirect:/food-menu"; 
    }

    @GetMapping("/delete-menu/{id}")
    public String deleteMenu(@PathVariable Long id) {
        ms.deleteMenu(id);
        
        return "redirect:/food-menu";
    }

	
	
	
}
