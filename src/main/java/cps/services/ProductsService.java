package cps.services;

import cps.entity.Customers;
import cps.entity.Products;
import cps.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private final ProductsRepository productsRepository;
    private final CustomersService customersService;

    public ProductsService(ProductsRepository productsRepository, CustomersService customersService){
        this.productsRepository = productsRepository;
        this.customersService = customersService;

    }
    @Transactional
    public void createProducts(Products products, Long customer_id){
        Customers customer = customersService.getById(customer_id);
        products.setCustomer_id(customer);
        productsRepository.save(products);
    }

    public List<Products> getALL(){
        return productsRepository.findAll();
    }

    public Products getById(Long id){
        return productsRepository.findById(id).orElse(null);
    }

    public void deleteProducts(Long id){productsRepository.deleteById(id);}

    public void editProducts(Customers customer, String title, String description, double price, boolean is_deleted, Timestamp created_at, Timestamp modified_at, Long id){
        productsRepository.editProducts(customer, title, description, price, is_deleted,created_at,modified_at,id);
    }
}
