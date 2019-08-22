package cps.controller;


import cps.entity.Products;
import cps.exception.CustomerNotFoundException;
import cps.exception.ProductNotFoundException;
import cps.repository.ProductsRepository;
import cps.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {


    private final ProductsService productsService;

    @Autowired
    public ProductController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping("customers/{customerId}/products")
    public ResponseEntity<List<Products>> getProduct(@PathVariable(value = "customerId") Long customerId){
        try{
            return ResponseEntity.ok(productsService.getByCustomerId(customerId));
        }
        catch (ProductNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,null,e);

        }
    }

    @PostMapping("customers/{customerId}/products")
    public ResponseEntity<Products> createProduct(@PathVariable(value = "customerId") Long customerId, @Valid @RequestBody Products product){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productsService.createProducts(customerId,product));
        }
        catch (CustomerNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,null,e);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") Long id)  {
        productsService.deleteProducts(id);
        return ResponseEntity.ok("Product with id = "+id+" has deleted successful");
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable(value = "id") Long id) {
        try{
            return ResponseEntity.ok(productsService.getById(id));
        }
        catch (ProductNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,null,e);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Products> editProduct(@PathVariable(value = "id") Long id,
                                @Valid @RequestBody Products productDetails) throws ProductNotFoundException{

       try {
           return ResponseEntity.ok(productsService.editProducts(id,productDetails));
       }
       catch (ProductNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,null,e);
       }
    }
}
