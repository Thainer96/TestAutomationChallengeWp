package com.wompi.test.builders;

import com.wompi.test.models.request.PaymentMethod;

import java.util.Map;

public class PaymentMethodBuilder {

    private PaymentMethodBuilder() {
    }

    public static PaymentMethod build(Map<String, String> data) {
        String type = data.getOrDefault("type", "");
        switch (type) {
            case "NEQUI":
                return buildNequi(data);
            case "BANCOLOMBIA_QR":
                return buildBancolombiaQr(data);
            case "BANCOLOMBIA_TRANSFER":
                return buildBancolombiaTransfer(data);
            default:
                throw new IllegalArgumentException("Tipo de método de pago no soportado: " + type);
        }
    }

    private static PaymentMethod buildNequi(Map<String, String> data) {
        return PaymentMethod.builder()
                .type("NEQUI")
                .phoneNumber(data.get("phone_number"))
                .build();
    }

    private static PaymentMethod buildBancolombiaQr(Map<String, String> data) {
        return PaymentMethod.builder()
                .type("BANCOLOMBIA_QR")
                .paymentDescription(data.get("payment_description"))
                .sandboxStatus(data.get("sandbox_status"))
                .build();
    }

    private static PaymentMethod buildBancolombiaTransfer(Map<String, String> data) {
        return PaymentMethod.builder()
                .type("BANCOLOMBIA_TRANSFER")
                .paymentDescription(data.get("payment_description"))
                .userType(data.get("user_type"))
                .build();
    }
}
