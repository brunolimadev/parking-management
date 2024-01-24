package br.com.fiap.parkingmanagement.model.entity.checkin;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
    private String type;
    private Card card;
    private String value;
}