package com.re.bai2.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class DishRepository {
    private final List<String> categories = Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");

    public List<String> findAllCategories(){
        return categories;
    }
}
