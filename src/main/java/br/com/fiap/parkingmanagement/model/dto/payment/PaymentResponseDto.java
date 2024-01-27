package br.com.fiap.parkingmanagement.model.dto.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;

public record PaymentResponseDto(
        @JsonProperty(value = "Forma de Pagamento")
        String formOfPayment,

        @JsonProperty(value = "Número do Cartão")
        String paymentDetails,

        @JsonProperty(value = "Valor Pago")
        double amount,

        @Valid
        StatusPaymentResponseDto status
) {
}
