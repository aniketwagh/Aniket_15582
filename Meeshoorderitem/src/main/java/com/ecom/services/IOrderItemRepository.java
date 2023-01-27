package com.ecom.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ecom.model.OrderItem;

@EnableJpaRepositories
@Repository
public interface IOrderItemRepository extends JpaRepository<OrderItem, Long> {

}
