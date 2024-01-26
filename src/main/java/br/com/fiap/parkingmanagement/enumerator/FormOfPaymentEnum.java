package br.com.fiap.parkingmanagement.enumerator;

import br.com.fiap.parkingmanagement.controller.exception.FormOfPaymentNotFoundException;
import lombok.Getter;

@Getter
public enum FormOfPaymentEnum {

    CREDIT_CARD(1, "Credit Card"),
    DEBIT_CARD(2, "Debit Card");

    private final int id;
    private final String description;

    FormOfPaymentEnum(int id, String description) {
        this.id = id;
        this.description = description;
    }

    private int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static FormOfPaymentEnum getById(int id) {
        for (FormOfPaymentEnum formOfPayment : values()) {
            if (formOfPayment.getId() == id) {
                return formOfPayment;
            }
        }
        throw new FormOfPaymentNotFoundException("Forma de pagamento não encontrada!  " + id);
    }

    public static String getDescriptionById(int id) {
        for (FormOfPaymentEnum formOfPayment : values()) {
            if (formOfPayment.getId() == id) {
                return formOfPayment.getDescription();
            }
        }
        throw new FormOfPaymentNotFoundException("Forma de pagamento não encontrada!  " + id);
    }

}
