package com.codegym.crud2bangbe.controller;

import com.codegym.crud2bangbe.model.Category;
import com.codegym.crud2bangbe.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll(){
        Iterable<Category> categories = categoryService.findAll();
        if (categories == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Category> findOne (@PathVariable Long id){
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createCity(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> editCity(@PathVariable Long id, @RequestBody Category newCategory){
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        newCategory.setId(id);
        return new ResponseEntity<>(categoryService.save(newCategory), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        categoryService.removeById(id);
    }

}
