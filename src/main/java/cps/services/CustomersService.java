package cps.services;

import cps.entity.Customers;
import cps.exception.CustomerNotFoundException;
import cps.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CustomersService {


    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository){
        this.customersRepository = customersRepository;
    }


    public Customers createCustomers(Customers customer){

        customer.setCreated_at(new Timestamp(System.currentTimeMillis()));
        customer.setModified_at(new Timestamp(System.currentTimeMillis()));
        Customers newCustomer = customersRepository.save(customer);
        return newCustomer;
    }

    public List<Customers> getALL(){
        return customersRepository.findAll();
    }

    public Customers getById(Long id) throws CustomerNotFoundException {

        return customersRepository.findById(id)
                .orElseThrow( () -> new CustomerNotFoundException(id));
    }

    public void deleteCustomers(Long id){
        customersRepository.deleteById(id);
    }

    public Customers editCustomers(Long id, Customers customer) throws CustomerNotFoundException{
        Customers oldCustomer = customersRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customer.setModified_at(oldCustomer.getCreated_at());
        customer.setId(id);
        customer.setModified_at(new Timestamp(System.currentTimeMillis()));
        Customers newCustomer = customersRepository.save(customer);
        return newCustomer;
    }
}
