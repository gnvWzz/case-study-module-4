package com.abcxyz.service.database_service;

import com.abcxyz.entities.Message;
import com.abcxyz.entities.OrderConfirmedToCustomer;
import com.abcxyz.model.OrderFromCustomerA;
import com.abcxyz.model.OrderFullFromShips;
import com.abcxyz.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService implements IDatabaseService{

    @Autowired
    private IOrderFromCustomerARepository orderFromCustomerARepository;

    @Autowired IOrderFullFromShipsRepository orderFullFromShipsRepository;

    @Autowired
    private IOrderConfirmedToCustomerRepository orderConfirmedToCustomerRepository;

    @Autowired
    private IMessageRepository messageRepository;

    @Override
    public OrderFromCustomerA getOrderFromCustomerA(String orderCode) {
        return orderFromCustomerARepository.findByOrderCode(orderCode);
    }

    @Override
    public OrderConfirmedToCustomer getOrderConfirmedToCustomer(String orderCode) {
        return orderConfirmedToCustomerRepository.findByOrderCode(orderCode);
    }

    @Override
    public OrderFullFromShips getOrderFullFromShips(String orderCode) {
        return orderFullFromShipsRepository.findByOrderCode(orderCode);
    }

    @Override
    public void saveOrderFromCustomerA(OrderFromCustomerA orderFromCustomerA) {
        orderFromCustomerARepository.save(orderFromCustomerA);
    }

    @Override
    public void saveOrderConfirmedToCustomer(OrderConfirmedToCustomer orderConfirmedToCustomer) {
        orderConfirmedToCustomerRepository.save(orderConfirmedToCustomer);
    }

    @Override
    public void saveOrderFullFromShips(OrderFullFromShips orderFullFromShips) {
        orderFullFromShipsRepository.save(orderFullFromShips);
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
