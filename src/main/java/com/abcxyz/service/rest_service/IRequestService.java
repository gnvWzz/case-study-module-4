package com.abcxyz.service.rest_service;

import com.abcxyz.dto.MessageDto;
import com.abcxyz.entities.Message;
import com.abcxyz.model.MessageDtoAndOrderCode;
import org.springframework.http.ResponseEntity;

public interface IRequestService {
    ResponseEntity<?> handleOrderFromCustomerToShips(String orderCode);

    ResponseEntity<?> handleOrderConfirmedToCustomerDto(MessageDtoAndOrderCode messageDtoAndOrderCode);

    ResponseEntity<?> handleConfirmationToCustomerA(MessageDto messageDto);
}
