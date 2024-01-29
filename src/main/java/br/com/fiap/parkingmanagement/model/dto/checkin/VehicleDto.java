package br.com.fiap.parkingmanagement.model.dto.checkin;

import br.com.fiap.parkingmanagement.enumerator.VehicleTypeEnum;
import jakarta.validation.constraints.NotNull;

public record VehicleDto(
        @NotNull(message = "O tipo de veículo não pode ser nulo.")
        VehicleTypeEnum type,
        @NotNull(message = "A placa do veículo não pode ser nulo.")
        String plate
) { }