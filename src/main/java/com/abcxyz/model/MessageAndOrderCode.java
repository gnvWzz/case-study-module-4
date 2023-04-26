package com.abcxyz.model;

import com.abcxyz.entities.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message_and_order_code")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageAndOrderCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Message.class)
    @JoinColumn(name = "message_id")
    private Message message;

    @Column(name = "order_code")
    private String orderCode;
}
