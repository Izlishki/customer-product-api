package cps.repository;

import cps.entity.Customers;
import cps.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface ProductsRepository extends JpaRepository<Products, Long>{

    @Query("update Products pr set pr.customer = ?1, pr.title = ?2, pr.description = ?3, pr.price = ?4,pr.is_deleted = ?5, " +
           "pr.created_at = ?6, pr.modified_at = ?7 where pr.id = ?8")
    void editProducts(Customers customer, String title, String description, double price, boolean is_deleted, Timestamp created_at, Timestamp modified_at, Long id);
}
