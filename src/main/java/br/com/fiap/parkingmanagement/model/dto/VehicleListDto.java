package br.com.fiap.parkingmanagement.model.dto;

import java.util.List;

public record VehicleListDto(
        List<VehicleDto> vehicles
) {

}
