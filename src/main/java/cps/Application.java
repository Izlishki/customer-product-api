package cps;

import cps.services.CustomersService;
import cps.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.sql.Timestamp;


@SpringBootApplication
public class Application {

    @Autowired
    private CustomersService customersService;

    @Autowired
    private ProductsService productsService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }


}
