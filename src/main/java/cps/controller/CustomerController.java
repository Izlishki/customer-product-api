package cps.controller;


import cps.entity.Customers;
import cps.exception.CustomerNotFoundException;
import cps.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {


    private final CustomersService customersService;

    @Autowired
    public CustomerController(CustomersService customersService){
        this.customersService = customersService;
    }


    @GetMapping("/customers")
    public ResponseEntity<List<Customers>> getAllCustomers(){
        return ResponseEntity.ok(customersService.getALL());
    }

    @PostMapping("/customers")
    public ResponseEntity<Customers> createCustomer(@Valid @RequestBody Customers customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customersService.createCustomers(customer));
    }

    @DeleteMapping("/customers/{id}")
    public  ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Long id) {
        customersService.deleteCustomers(id);
        return ResponseEntity.ok("Customer with id = "+id+" has deleted successful");
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable(value = "id") Long id){
        try{
            return ResponseEntity.ok(customersService.getById(id));
        }
        catch (CustomerNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,null,e);
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customers> editCustomer(@Valid @RequestBody Customers customersDetails,
                                  @PathVariable(value = "id") Long id) {
        try{
            return ResponseEntity.ok(customersService.editCustomers(id,customersDetails));
        }
        catch (CustomerNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,null,e);
        }
    }
}
