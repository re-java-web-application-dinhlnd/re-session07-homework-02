package com.re.bai2.controller;

import com.re.bai2.model.Dish;
import com.re.bai2.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/merchant/dish")
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @ModelAttribute("categories")
    public List<String> populateCategories() {
        return dishService.getAllCategories();
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "dish-add";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        model.addAttribute("dish", new Dish("Trà sữa", "Đồ uống"));
        return "dish-edit";
    }

    @GetMapping("/search")
    public String showSearchPage() {
        return "dish-search";
    }

    @GetMapping("/categories")
    public String showCategoriesPage() {
        return "category-list";
    }
}
