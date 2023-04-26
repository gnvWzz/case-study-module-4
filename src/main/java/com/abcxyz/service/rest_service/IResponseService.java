package com.abcxyz.service.rest_service;

import com.abcxyz.entities.Message;
import com.abcxyz.model.OrderFromCustomerA;
import com.abcxyz.model.OrderFullFromShips;

public interface IResponseService {
    void receiveOrderFromCustomerA(OrderFromCustomerA orderFromCustomerA);

    void receiveOrderFullFromShips(OrderFullFromShips orderFullFromShips);

    void receiveSignal(Message message, String orderCode);
}
