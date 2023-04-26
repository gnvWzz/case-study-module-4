package com.abcxyz.service.rest_service;

import com.abcxyz.entities.Message;
import com.abcxyz.entities.OrderConfirmedToCustomer;
import com.abcxyz.model.OrderFromCustomerA;
import com.abcxyz.model.OrderFullFromShips;
import com.abcxyz.service.database_service.IDatabaseService;
import com.abcxyz.utils.mapper.UtilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService implements IResponseService {
    @Autowired
    private UtilMapper mapper;

    @Autowired
    private IDatabaseService databaseService;

    @Override
    public void receiveOrderFromCustomerA(OrderFromCustomerA orderFromCustomerA) {
        databaseService.saveOrderFromCustomerA(orderFromCustomerA);

        OrderConfirmedToCustomer orderConfirmedToCustomer = mapper.convertToOrderConfirmedToCustomer(orderFromCustomerA);

        orderConfirmedToCustomer.setStatus(0);

        databaseService.saveOrderConfirmedToCustomer(orderConfirmedToCustomer);
    }

    @Override
    public void receiveOrderFullFromShips(OrderFullFromShips orderFullFromShips) {
        databaseService.saveOrderFullFromShips(orderFullFromShips);

        OrderConfirmedToCustomer orderConfirmedToCustomer = databaseService.getOrderConfirmedToCustomer(orderFullFromShips.getOrderCode());

        orderConfirmedToCustomer.setStatus(1);

        orderConfirmedToCustomer.setArrivalDate(orderFullFromShips.getArrivalDate());

        orderConfirmedToCustomer.setDepartureDate(orderFullFromShips.getDepartureDate());

        databaseService.saveOrderConfirmedToCustomer(orderConfirmedToCustomer);
    }

    @Override
    public void receiveSignal(Message message, String orderCode) {
        databaseService.saveMessage(message);

        OrderConfirmedToCustomer orderConfirmedToCustomer = databaseService.getOrderConfirmedToCustomer(orderCode);

        orderConfirmedToCustomer.setStatus(2);

        databaseService.saveOrderConfirmedToCustomer(orderConfirmedToCustomer);
    }


}
