package cps.services;

import cps.entity.Customers;
import cps.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CustomersService {

    @Autowired
    private final CustomersRepository customersRepository;


    public CustomersService(CustomersRepository customersRepository){
        this.customersRepository = customersRepository;
    }

    public void createCustomers(Customers customer){
        customersRepository.save(customer);
    }

    public List<Customers> getALL(){
        return customersRepository.findAll();
    }

    public Customers getById(Long id){
        return customersRepository.findById(id).orElse(null);
    }

    public void deleteCustomers(Long id){
        customersRepository.deleteById(id);
    }

    public void editCustomers(String title, boolean is_deleted, Timestamp created_at, Timestamp modified_at, Long id){
        customersRepository.editCustomers(title,is_deleted,created_at,modified_at,id);
    }
}
