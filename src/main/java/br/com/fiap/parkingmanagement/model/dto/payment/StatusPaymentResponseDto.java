package br.com.fiap.parkingmanagement.model.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StatusPaymentResponseDto(
        @JsonProperty(value = "Pagamento aprovado:")
        boolean sucess,
        @JsonProperty(value = "Mensagem")
        String message
) {
}
