package cps.repository;

import cps.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

}
