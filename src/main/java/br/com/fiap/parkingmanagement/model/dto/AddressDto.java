package br.com.fiap.parkingmanagement.model.dto;

import lombok.Data;

@Data
public class AddressDto{
    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;
    String ibge;
    String gia;
    String ddd;
    String siafi;
}
