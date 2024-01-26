package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.controller.exception.PaymentException;
import br.com.fiap.parkingmanagement.enumerator.FormOfPaymentEnum;
import br.com.fiap.parkingmanagement.model.dto.checkin.PaymentDto;
import br.com.fiap.parkingmanagement.model.dto.payment.PaymentResponseDto;
import br.com.fiap.parkingmanagement.model.dto.payment.StatusPaymentResponseDto;
import br.com.fiap.parkingmanagement.service.PaymentService;
import br.com.fiap.parkingmanagement.util.CardUtil;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        String cardExpirationDate = paymentDto.card().expiringDate();
        StatusPaymentResponseDto statusPaymentResponseDto = validateCardExpirationDate(cardExpirationDate);
        return new PaymentResponseDto(typeCard, numberCard, amount, statusPaymentResponseDto);
    }

    private StatusPaymentResponseDto validateCardExpirationDate(String cardExpirationDate) {

        boolean status;
        String message = "";

        Date dataAtual = new Date();

        // Define o formato da data esperado (MM/yy)
        SimpleDateFormat formatoData = new SimpleDateFormat("MM/yy");
        formatoData.setLenient(false); // Para tornar a validação rigorosa

        try {
            // Converte a string da data de validade para um objeto Date
            Date dataValidadeCartao = formatoData.parse(cardExpirationDate);

            // Verifica se a data de validade é posterior à data atual
            if (dataValidadeCartao.after(dataAtual)) {
                status = true;
                message = "Pagamento aprovado com Sucesso!";
            } else {
                status = false;
                message = "A data de validade do cartão está expirada!";
            }
            return new StatusPaymentResponseDto(status, message);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String applyMaskCardNumber(PaymentDto paymentDto) {
        return CardUtil.maskCardNumber(paymentDto.card().number());
    }

    private String checkTypeCard(PaymentDto paymentDto) {
        if (FormOfPaymentEnum.getDescriptionById(Integer.parseInt(paymentDto.card().type())) != null)
            return FormOfPaymentEnum.getDescriptionById(Integer.parseInt(paymentDto.card().type()));
        else {
            throw new PaymentException("Erro", "Cartão Inválido!");
        }
    }
}


