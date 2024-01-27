package br.com.fiap.parkingmanagement.util;

public class CardUtil {

    public static String maskCardNumber(String cardNumber) {
        String firstFourDigits = cardNumber.substring(0, 4);
        String lastFourDigits = cardNumber.substring(cardNumber.length() - 4);

        // Mascara os dígitos restantes
        String maskedDigits = "*".repeat(cardNumber.length() - 8);

        return firstFourDigits + "." + maskedDigits.substring(0, 4) + "." + maskedDigits.substring(0, 4) + "." + lastFourDigits;
    }

}
