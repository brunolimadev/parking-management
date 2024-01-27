package br.com.fiap.parkingmanagement.service;

import br.com.fiap.parkingmanagement.model.dto.checkin.PaymentDto;
import br.com.fiap.parkingmanagement.model.dto.payment.PaymentResponseDto;

public interface PaymentService {

    PaymentResponseDto process(PaymentDto paymentDto);

    PaymentResponseDto cardPayment(PaymentDto paymentDto);


}
