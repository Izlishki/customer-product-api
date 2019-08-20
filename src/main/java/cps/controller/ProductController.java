package cps.controller;


import cps.entity.Products;
import cps.exception.ProductNotFoundException;
import cps.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductsRepository productsRepository;


    @GetMapping("/products")
    public List getAllProducts(){
        return productsRepository.findAll();
    }

    @PostMapping("/products")
    public Products createProduct(@Valid @RequestBody Products product){
        return productsRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable(value = "id") Long id) throws ProductNotFoundException {

        Products product = productsRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        productsRepository.delete(product);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/products/{id}")
    public Products getProductById(@PathVariable(value = "id") Long id) throws ProductNotFoundException{
        return productsRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/products/{id}")
    public Products editProduct(@PathVariable(value = "id") Long id,
                                @Valid @RequestBody Products productDetails) throws ProductNotFoundException{

        Products product = productsRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setTitle(productDetails.getTitle());
        product.setCustomer_id(productDetails.getCustomer_id());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setIs_deleted(productDetails.getIs_deleted());
        product.setCreated_at(productDetails.getCreated_at());
        product.setModefied_at(productDetails.getModefied_at());

        Products updatedProduct = productsRepository.save(product);
        return updatedProduct;
    }
}
