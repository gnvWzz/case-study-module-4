package com.abcxyz.utils.mapper;

import com.abcxyz.dto.MessageDto;
import com.abcxyz.dto.OrderConfirmedToCustomerDto;
import com.abcxyz.dto.OrderFromCustomerAToShips;
import com.abcxyz.entities.Message;
import com.abcxyz.entities.OrderConfirmedToCustomer;
import com.abcxyz.model.OrderFromCustomerA;
import com.abcxyz.model.OrderFullFromShips;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilMapper {
    @Autowired
    private ModelMapper modelMapper;

    public OrderConfirmedToCustomer convertToOrderConfirmedToCustomer(OrderFromCustomerA orderFromCustomerA) {
        return modelMapper.map(orderFromCustomerA, OrderConfirmedToCustomer.class);
    }

    public OrderFromCustomerAToShips convertToOrderFromCustomerAToShips(OrderFromCustomerA orderFromCustomerA) {
        return modelMapper.map(orderFromCustomerA, OrderFromCustomerAToShips.class);
    }

    public OrderConfirmedToCustomerDto convertToOrderConfirmedToCustomerDto(OrderConfirmedToCustomer orderConfirmedToCustomer) {
        return modelMapper.map(orderConfirmedToCustomer, OrderConfirmedToCustomerDto.class);
    }

    public Message convertToMessageEntity(MessageDto messageDto) {
        return modelMapper.map(messageDto, Message.class);
    }
}
