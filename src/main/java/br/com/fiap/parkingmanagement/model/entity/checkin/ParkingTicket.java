package br.com.fiap.parkingmanagement.model.entity.checkin;

import br.com.fiap.parkingmanagement.model.entity.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ParkingTicket {
    @Id
    private String id;
    private String period;
    private String initialDate;
    private String finalDate;
    private Zone zone;
    private Vehicle vehicle;
    private Payment payment;

    @DBRef
    private User user;
}