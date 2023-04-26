package com.abcxyz.service.database_service;

import com.abcxyz.entities.Message;
import com.abcxyz.entities.OrderConfirmedToCustomer;
import com.abcxyz.model.OrderFromCustomerA;
import com.abcxyz.model.OrderFullFromShips;

public interface IDatabaseService {
    OrderFromCustomerA getOrderFromCustomerA(String orderCode);

    OrderConfirmedToCustomer getOrderConfirmedToCustomer(String orderCode);

    OrderFullFromShips getOrderFullFromShips(String orderCode);

    void saveOrderFromCustomerA(OrderFromCustomerA orderFromCustomerA);

    void saveOrderConfirmedToCustomer(OrderConfirmedToCustomer orderConfirmedToCustomer);

    void saveOrderFullFromShips(OrderFullFromShips orderFullFromShips);

    void saveMessage(Message message);

}
