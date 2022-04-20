package com.codegym.crud2bangbe.controller;

import com.codegym.crud2bangbe.model.Product;
import com.codegym.crud2bangbe.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll(){
        Iterable<Product> products = productService.findAll();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productOptional.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED) ;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct (@PathVariable Long id){
         productService.removeById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id,@RequestBody Product newProduct){
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newProduct,HttpStatus.OK);
    }

}
