package com.abcxyz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderFromCustomerAToShips implements Serializable {
    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "departure_location")
    private String departureLocation;

    private String destination;

    private long weight;
}
