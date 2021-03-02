package com.eunchae.restaurantbooker.interfaces;

import com.eunchae.restaurantbooker.application.CategoryService;
import com.eunchae.restaurantbooker.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> list() {
        List<Category> regions = categoryService.getCategories();

        return regions;
    }
}

