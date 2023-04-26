package com.abcxyz.service.rest_service;

import com.abcxyz.dto.MessageDto;
import com.abcxyz.dto.OrderConfirmedToCustomerDto;
import com.abcxyz.dto.OrderFromCustomerAToShips;
import com.abcxyz.entities.Message;
import com.abcxyz.entities.OrderConfirmedToCustomer;
import com.abcxyz.model.MessageDtoAndOrderCode;
import com.abcxyz.service.database_service.IDatabaseService;
import com.abcxyz.utils.mapper.UtilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestService implements IRequestService {

    @Autowired
    private IDatabaseService databaseService;

    @Autowired
    private UtilMapper mapper;

    @Override
    public ResponseEntity<?> handleOrderFromCustomerToShips(String orderCode) {
        databaseService.saveOrderConfirmedToCustomer(databaseService.getOrderConfirmedToCustomer(orderCode));

        OrderFromCustomerAToShips orderFromCustomerAToShips = mapper.convertToOrderFromCustomerAToShips(databaseService.getOrderFromCustomerA(orderCode));

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<OrderFromCustomerAToShips> entity = new HttpEntity<>(orderFromCustomerAToShips);

        ResponseEntity<?> responseEntity = restTemplate.exchange(
                "http://192.168.4.89:8080/api/order_contact",
                HttpMethod.POST,
                entity,
                String.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.ACCEPTED) {
            return new ResponseEntity<>("DONE", HttpStatus.OK);
        } else if (responseEntity.getStatusCode() == HttpStatus.NO_CONTENT) {
            System.out.println(responseEntity.getBody());
            return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> handleConfirmationToCustomerA(MessageDto messageDto) {
        databaseService.saveMessage(mapper.convertToMessageEntity(messageDto));

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<MessageDto> entity = new HttpEntity<>(messageDto);

        ResponseEntity<?> responseEntity = restTemplate.exchange(
                "http://192.168.4.120:8080/api/save-confirmer",
                HttpMethod.POST,
                entity,
                String.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return new ResponseEntity<>("DONE", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> handleOrderConfirmedToCustomerDto(MessageDtoAndOrderCode messageDtoAndOrderCode) {
        databaseService.saveMessage(mapper.convertToMessageEntity(messageDtoAndOrderCode.getMessageDto()));

        OrderConfirmedToCustomer orderConfirmedToCustomer = databaseService.getOrderConfirmedToCustomer(messageDtoAndOrderCode.getOrderCode());

        orderConfirmedToCustomer.setStatus(3);

        databaseService.saveOrderConfirmedToCustomer(orderConfirmedToCustomer);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<MessageDto> entity = new HttpEntity<>(messageDtoAndOrderCode.getMessageDto());

        ResponseEntity<?> responseEntity = restTemplate.exchange(
                "http://192.168.4.120:8080/api/receive-order",
                HttpMethod.POST,
                entity,
                String.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return new ResponseEntity<>("DONE", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
