package com.tw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.entity.FoodMenu;

public interface MenuRepo extends JpaRepository<FoodMenu, Long> {

}
