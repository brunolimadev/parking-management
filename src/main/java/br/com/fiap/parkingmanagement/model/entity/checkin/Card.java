package br.com.fiap.parkingmanagement.model.entity.checkin;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Card {
    private String type;
    private String number;
    private String verificationCode;
}