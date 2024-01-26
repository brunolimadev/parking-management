package br.com.fiap.parkingmanagement.controller;


import br.com.fiap.parkingmanagement.controller.exception.PaymentException;
import br.com.fiap.parkingmanagement.model.dto.checkin.PaymentDto;
import br.com.fiap.parkingmanagement.model.dto.payment.PaymentResponseDto;
import br.com.fiap.parkingmanagement.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Autowired
    public PaymentService paymentService;

    @PostMapping()
    public ResponseEntity<PaymentResponseDto> processar(@Valid @RequestBody PaymentDto paymentDto) {

        PaymentResponseDto response;

        try {
            response = paymentService.process(paymentDto);
        } catch (PaymentException e) {
            throw new PaymentException("Ocorreu um erro ao processar o pagamento!", e.getMessage());
        }
        return ResponseEntity.ok().body(response);
    }
}
