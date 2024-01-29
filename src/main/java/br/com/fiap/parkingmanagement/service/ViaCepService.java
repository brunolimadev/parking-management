package br.com.fiap.parkingmanagement.service;

import br.com.fiap.parkingmanagement.model.dto.AddressDto;

public interface ViaCepService {
    public AddressDto searchAddressByCep(String cep);
}
