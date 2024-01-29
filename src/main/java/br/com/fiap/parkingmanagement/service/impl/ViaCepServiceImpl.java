package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.model.dto.AddressDto;
import br.com.fiap.parkingmanagement.service.ViaCepService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepServiceImpl implements ViaCepService {

    @Value("${viacep.url}")
    private String url;

    public ViaCepServiceImpl() {
    }

    /**
     * Método responsável por buscar um endereço pelo CEP
     *
     * @param cep
     * @return
     */
    @Override
    public AddressDto searchAddressByCep(String cep) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(url + "/{cep}/json", AddressDto.class, cep);
    }
}
