package com.example.controller;

import com.example.dto.ProductDTO;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO.Request.Create dto){
        return ResponseEntity.ok().body(productService.createProduct(dto));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllPublicProduct(){
        return ResponseEntity.ok().body(productService.getAllPublicProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdPublicProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(productService.getByIdPublicProduct(id));
    }

    @GetMapping("/private")
    public ResponseEntity<?> getAllPrivateProduct(){
        return ResponseEntity.ok().body(productService.getAllPrivateProduct());
    }

    @GetMapping("/private/{id}")
    public ResponseEntity<?> getByIdPrivateProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(productService.getByIdPrivateProduct(id));
    }
}
