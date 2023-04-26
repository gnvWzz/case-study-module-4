package com.abcxyz.repository;

import com.abcxyz.model.OrderFromCustomerA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderFromCustomerARepository extends JpaRepository<OrderFromCustomerA, String> {
    OrderFromCustomerA findByOrderCode(String orderCode);
}
