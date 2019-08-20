package cps.controller;


import cps.entity.Customers;
import cps.exception.CustomerNotFoundException;
import cps.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomersRepository customersRepository;

    @GetMapping("/customers")
    public List getAllCustomers(){
        return customersRepository.findAll();
    }

    @PostMapping("/customers")
    public Customers createCustomer(@Valid @RequestBody Customers customer){
        return customersRepository.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable(value = "id") Long id) throws CustomerNotFoundException{

        Customers customer = customersRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customersRepository.delete(customer);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/customers/{id}")
    public Customers getCustomerById(@PathVariable(value = "id") Long id) throws CustomerNotFoundException{
        return customersRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customers/{id}")
    public Customers editCustomer(@Valid @RequestBody Customers customersDetails,
                                  @PathVariable(value = "id") Long id) throws CustomerNotFoundException{

        Customers customer = customersRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customer.setTitle(customersDetails.getTitle());
        customer.setIs_deleted(customersDetails.getIs_deleted());
        customer.setCreated_at(customersDetails.getCreated_at());
        customer.setModified_at(customersDetails.getModified_at());

        Customers updatedCustomer = customersRepository.save(customer);
        return updatedCustomer;
    }
}
