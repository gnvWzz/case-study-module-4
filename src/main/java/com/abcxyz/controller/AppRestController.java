package com.abcxyz.controller;

import com.abcxyz.dto.MessageDto;
import com.abcxyz.dto.OrderFromCustomerAToShips;
import com.abcxyz.entities.Message;
import com.abcxyz.model.MessageAndOrderCode;
import com.abcxyz.model.MessageDtoAndOrderCode;
import com.abcxyz.model.OrderFromCustomerA;
import com.abcxyz.model.OrderFullFromShips;
import com.abcxyz.service.database_service.IDatabaseService;
import com.abcxyz.service.rest_service.IRequestService;
import com.abcxyz.service.rest_service.IResponseService;
import com.abcxyz.utils.mapper.UtilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class AppRestController {
    @Autowired
    private IResponseService responseService;

    @Autowired
    private IRequestService requestService;

    @Autowired
    private IDatabaseService databaseService;

    @Autowired
    private UtilMapper mapper;

    //status 0
    @PostMapping("/receive-order-from-customer-A")
    public ResponseEntity<?> receiveOrderFromCustomerA(@RequestBody OrderFromCustomerA orderFromCustomerA) {
        responseService.receiveOrderFromCustomerA(orderFromCustomerA);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/send-order-from-customer-A-to-ships")
    public void sendOrderFromCustomerAToShips(@RequestBody String orderCode) {
        requestService.handleOrderFromCustomerToShips(orderCode);
    }

    //status 1
    @PostMapping("/receive-full-order-from-ships")
    public ResponseEntity<?> receiveFullOrderFromShips(@RequestBody OrderFullFromShips orderFullFromShips) {
        responseService.receiveOrderFullFromShips(orderFullFromShips);
        return new ResponseEntity<>("OK CON DE^",HttpStatus.OK);
    }

    @PostMapping("/send-confirmation-to-customer-A")
    public void sendConfirmationToCustomerA(@RequestBody MessageDto messageDto) {
        requestService.handleConfirmationToCustomerA(messageDto);
    }

    //status 2
    @PostMapping("/receive-signal")
    public ResponseEntity<?> receiveSignal(@RequestBody MessageAndOrderCode messageAndOrderCode) {
        responseService.receiveSignal(messageAndOrderCode.getMessage(),messageAndOrderCode.getOrderCode());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //status 3
    @PostMapping("/send-order-to-customer-B")
    public void sendOrderToCustomerB(@RequestBody MessageDtoAndOrderCode messageDtoAndOrderCode) {
        requestService.handleOrderConfirmedToCustomerDto(messageDtoAndOrderCode);
    }
}
