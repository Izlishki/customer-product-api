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

//    @EventListener(ApplicationReadyEvent.class)
//    private void testJpaMethods(){
//        Timestamp now = new Timestamp(System.currentTimeMillis());
////        Customers customers = new Customers();
////        customers.setTitle("Ваня");
////        customers.setIs_deleted(false);
////        customers.setCreated_at(now);
////        customers.setModified_at(now);
////        customersService.createCustomers(customers);
////        Products products = new Products();
////        products.setTitle("Семки");
////        products.setDescription("Семки как семки, хули тут объяснять");
////        products.setIs_deleted(false);
////        products.setPrice(1488);
////        products.setCreated_at(now);
////        products.setModefied_at(now);
////        productsService.createProducts(products,2l);
//        productsService.getALL().forEach(it-> System.out.println(it.toString()));
//        customersService.getALL().forEach(it -> System.out.println(it.toString()));
//
//    }

}