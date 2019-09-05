package cps.services;

import cps.entity.Customers;
import cps.entity.Products;
import cps.exception.CustomerNotFoundException;
import cps.exception.ProductNotFoundException;
import cps.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductsService {


    private final ProductsRepository productsRepository;
    private final CustomersService customersService;

    @Autowired
    public ProductsService(ProductsRepository productsRepository, CustomersService customersService){
        this.productsRepository = productsRepository;
        this.customersService = customersService;

    }

    @Transactional
    public Products createProducts( Long customer_id, Products product) throws CustomerNotFoundException {
        Customers customer = customersService.getById(customer_id);
        product.setCustomerId(customer);
        product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        product.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        Products newProduct = productsRepository.save(product);
        return newProduct;
    }

    public List<Products> getByCustomerId(Long id) throws ProductNotFoundException {
        return productsRepository.findByCustomerId(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Products getById(Long id) throws ProductNotFoundException{
        return productsRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));
    }

    public void deleteProducts(Long id){
        productsRepository.deleteById(id);
    }

    @Transactional
    public Products editProducts(Long id, Products product) throws ProductNotFoundException{
        Products oldProduct = productsRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));
        product.setId(oldProduct.getId());
        product.setCreatedAt(oldProduct.getCreatedAt());
        product.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        product.setCustomerId(oldProduct.getCustomerId());
        Products newProduct = productsRepository.save(product);
        return newProduct;
    }
}
