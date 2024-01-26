package com.psr.Controller;

import com.psr.Models.Category;
import com.psr.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/api")
public class CategoryContoller {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/index")
    public String getAll(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    // boton añadir
    @GetMapping("/add")
    public String addCat(Category category){
        return("add");
    }

    // Logica de Add
    @PostMapping("/addcat")
    public String addCategory(@Validated Category category, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add";
        }
        categoryRepository.save(category);
        return "redirect:/api/index";
    }


    // Editar categoria
    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") int id, Model model){
        Category category = categoryRepository.findById(id).get();
        model.addAttribute("category", category);
        return "update";
    }

    @PostMapping("/updateapi/{id}")
    public String updateApi(@PathVariable("id") int id, @Validated Category category, BindingResult result, Model model){
        category.setCategoryId(id);
        if(result.hasErrors()){
            return "update";
        }
        categoryRepository.save(category);
        return("redirect:/api/index");
    }

    @GetMapping("/delete/{id}")
    public String deleteCat(@PathVariable("id") int id){
        categoryRepository.deleteById(id);
        return "redirect:/api/index";
    }


}
