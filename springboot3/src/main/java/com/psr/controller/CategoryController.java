package com.psr.controller;

import com.psr.models.Category;
import com.psr.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/category")
    public @ResponseBody Iterable<Category> getAll(){
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    public Category getById(@PathVariable int id){
        return categoryRepository.findById(id).get();
    }

    @PostMapping("/category")
    public Category add(@RequestBody Category category){
      return categoryRepository.save(category);
    }

    @PutMapping("/category/{id}")
    public Category update(@RequestBody Category category, @PathVariable int id) {
        try {
            Category old = categoryRepository.findById(id).get();
            old.setName((category.getName()));
            return categoryRepository.save(old);
        } catch (Exception ex) {
            return new Category("Categoria no encontrada");
        }
    }
    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable int id){
            categoryRepository.deleteById(id);
        }

    }


