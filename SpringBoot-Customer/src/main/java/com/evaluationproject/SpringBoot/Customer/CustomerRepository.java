package com.evaluationproject.SpringBoot.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

   // @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Optional<Customer> findCustomerByPesel(String pesel);
}
