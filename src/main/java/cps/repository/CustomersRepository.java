package cps.repository;

import cps.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

    @Query("update Customers c set c.title = ?1, c.is_deleted = ?2, c.created_at = ?3, c.modified_at = ?4 where c.id = ?5")
    void editCustomers(String title, boolean is_deleted, Timestamp created_at, Timestamp modified_at, Long id);
}
