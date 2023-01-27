package com.ecom.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ecom.model.Orders;

@EnableJpaRepositories
@Repository
public interface IOrdersRepository extends JpaRepository<Orders, Long> {

}
