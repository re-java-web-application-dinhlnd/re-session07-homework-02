package com.re.bai2.service;

import com.re.bai2.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<String> getAllCategories(){
        return dishRepository.findAllCategories();
    }
}
