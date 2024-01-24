package br.com.fiap.parkingmanagement.model.entity.checkin;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Zone {
    private String id;
    private String local;
    private String price;
}