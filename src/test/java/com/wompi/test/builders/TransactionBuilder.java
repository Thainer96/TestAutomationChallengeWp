package com.wompi.test.builders;

import com.wompi.test.models.request.TransactionRequest;

import java.util.Map;

public class TransactionBuilder {

    private TransactionBuilder() {
    }

    public static TransactionRequest fromDataTable(Map<String, String> data,
                                                    String acceptanceToken,
                                                    String acceptPersonalAuth,
                                                    String signature) {
        TransactionRequest request = new TransactionRequest();
        request.setAmountInCents(Integer.parseInt(data.get("amount_in_cents")));
        request.setCurrency(data.get("currency"));
        request.setCustomerEmail(data.get("customer_email"));
        request.setReference(data.get("reference"));
        request.setAcceptanceToken(acceptanceToken);
        request.setAcceptPersonalAuth(acceptPersonalAuth);
        request.setSignature(signature);
        request.setPaymentMethod(PaymentMethodBuilder.build(data));
        return request;
    }
}
