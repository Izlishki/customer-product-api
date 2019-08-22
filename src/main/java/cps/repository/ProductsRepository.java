package cps.repository;

import cps.entity.Customers;
import cps.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Long>{

    Optional<List<Products>> findByCustomerId(Long customerId);
}
