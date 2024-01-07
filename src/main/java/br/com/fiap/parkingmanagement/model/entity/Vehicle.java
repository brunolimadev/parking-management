package br.com.fiap.parkingmanagement.model.entity;

import br.com.fiap.parkingmanagement.enumerator.VehicleTypeEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Vehicle {

    @Id
    private String id;

    private String name;

    private String plate;

    private String model;

    private VehicleTypeEnum type;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @DBRef
    private User user;
}
