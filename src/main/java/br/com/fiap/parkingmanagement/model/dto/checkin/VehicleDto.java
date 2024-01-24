package br.com.fiap.parkingmanagement.model.dto.checkin;

import br.com.fiap.parkingmanagement.enumerator.VehicleTypeEnum;

public record VehicleDto(
        VehicleTypeEnum type,
        String plate
) { }