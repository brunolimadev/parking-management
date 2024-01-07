package br.com.fiap.parkingmanagement.model.dto;

import br.com.fiap.parkingmanagement.enumerator.VehicleTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record VehicleDto(

        @NotNull(message = "O nome do veículo não pode ser nulo.")
        String name,
        @NotNull(message = "O modelo do veículo não pode ser nulo.")
        String model,
        @NotNull(message = "O tipo do veículo não pode ser nulo.")
        VehicleTypeEnum type,
        @NotNull(message = "A placa do veículo não pode ser nulo.")
        String plate,
        @JsonIgnore
        LocalDateTime createdAt,
        @JsonIgnore
        LocalDateTime updatedAt
) {
}
