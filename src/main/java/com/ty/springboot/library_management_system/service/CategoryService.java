package com.ty.springboot.library_management_system.service;

import com.ty.springboot.library_management_system.entity.Category;
import com.ty.springboot.library_management_system.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository  categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category getById(Long id){
        Optional<Category> opt = categoryRepository.findById(id);
        if(opt.isPresent()) return opt.get();
        throw new RuntimeException("Id not found");
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Category update(Long id , Category category){
        boolean exists = categoryRepository.existsById(id);
        if(exists) return categoryRepository.save(category);
        throw new RuntimeException("Id not found");
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

}
