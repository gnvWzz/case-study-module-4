package com.abcxyz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "message_dto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_dto_id")
    private long id;

    private String message;

    private String date;

    public MessageDto(String message, String date) {
        this.message = message;
        this.date = date;
    }
}
