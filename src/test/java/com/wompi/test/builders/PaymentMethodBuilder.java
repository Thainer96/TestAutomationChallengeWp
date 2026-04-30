package com.wompi.test.builders;

import com.wompi.test.models.request.PaymentMethod;

import java.util.Map;

public class PaymentMethodBuilder {

    private PaymentMethodBuilder() {
    }

    public static PaymentMethod build(Map<String, String> data) {
        String type = data.getOrDefault("type", "");
        return switch (type) {
            case "NEQUI" -> buildNequi(data);
            case "BANCOLOMBIA_QR" -> buildBancolombiaQr(data);
            case "PCOL" -> buildPcol(data);
            case "BANCOLOMBIA_TRANSFER" -> buildBancolombiaTransfer(data);
            default -> throw new IllegalArgumentException("Tipo de método de pago no soportado: " + type);
        };
    }

    private static PaymentMethod buildNequi(Map<String, String> data) {
        PaymentMethod pm = new PaymentMethod();
        pm.setType("NEQUI");
        pm.setPhoneNumber(data.get("phone_number"));
        return pm;
    }

    private static PaymentMethod buildBancolombiaQr(Map<String, String> data) {
        PaymentMethod pm = new PaymentMethod();
        pm.setType("BANCOLOMBIA_QR");
        pm.setPaymentDescription(data.get("payment_description"));
        pm.setSandboxStatus(data.get("sandbox_status"));
        return pm;
    }

    private static PaymentMethod buildPcol(Map<String, String> data) {
        PaymentMethod pm = new PaymentMethod();
        pm.setType("PCOL");
        pm.setSandboxStatus(data.get("sandbox_status"));
        return pm;
    }

    private static PaymentMethod buildBancolombiaTransfer(Map<String, String> data) {
        PaymentMethod pm = new PaymentMethod();
        pm.setType("BANCOLOMBIA_TRANSFER");
        pm.setPaymentDescription(data.get("payment_description"));
        pm.setUserType(data.get("user_type"));
        return pm;
    }
}
