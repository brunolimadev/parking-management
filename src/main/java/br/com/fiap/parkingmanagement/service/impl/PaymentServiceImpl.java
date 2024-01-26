package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.controller.exception.PaymentException;
import br.com.fiap.parkingmanagement.enumerator.FormOfPaymentEnum;
import br.com.fiap.parkingmanagement.model.dto.checkin.PaymentDto;
import br.com.fiap.parkingmanagement.model.dto.payment.PaymentResponseDto;
import br.com.fiap.parkingmanagement.service.PaymentService;
import br.com.fiap.parkingmanagement.util.CardUtil;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentResponseDto process(PaymentDto paymentDto) {
       return cardPayment(paymentDto);
    }

    @Override
    public PaymentResponseDto cardPayment(PaymentDto paymentDto) {

        String numberCard = applyMaskCardNumber(paymentDto);
        String typeCard = checkTypeCard(paymentDto);
        double amount = paymentDto.amount();

        return new PaymentResponseDto(typeCard, numberCard, amount);
    }

    private String applyMaskCardNumber(PaymentDto paymentDto) {
        return CardUtil.maskCardNumber(paymentDto.card().number());
    }

    private String checkTypeCard(PaymentDto paymentDto) {


        if (FormOfPaymentEnum.getDescriptionById(Integer.parseInt(paymentDto.card().type())) != null)
            return FormOfPaymentEnum.getDescriptionById(Integer.parseInt(paymentDto.card().type()));
    else {
        throw new PaymentException("Erro na validação do cartão","teste");
        }
    }
}
