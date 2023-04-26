package com.abcxyz.repository;

import com.abcxyz.entities.OrderConfirmedToCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderConfirmedToCustomerRepository extends JpaRepository<OrderConfirmedToCustomer, String> {
    OrderConfirmedToCustomer findByOrderCode(String orderCode);
}
