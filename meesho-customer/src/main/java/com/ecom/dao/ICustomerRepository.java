package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
