package com.abcxyz.model;

import com.abcxyz.dto.MessageDto;
import com.abcxyz.entities.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "message_dto_and_order_code")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDtoAndOrderCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = MessageDto.class)
    @JoinColumn(name = "message_dto_id")
    private MessageDto messageDto;

    @Column(name = "order_code")
    private String orderCode;

    public MessageDtoAndOrderCode(MessageDto messageDto, String orderCode) {
        this.messageDto = messageDto;
        this.orderCode = orderCode;
    }
}
