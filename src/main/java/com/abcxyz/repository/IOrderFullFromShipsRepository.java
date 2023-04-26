package com.abcxyz.repository;

import com.abcxyz.model.OrderFullFromShips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderFullFromShipsRepository extends JpaRepository<OrderFullFromShips, String > {
    OrderFullFromShips findByOrderCode(String orderCode);
}
