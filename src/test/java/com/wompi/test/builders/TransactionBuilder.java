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
        return TransactionRequest.builder()
                .amountInCents(Integer.parseInt(data.get("amount_in_cents")))
                .currency(data.get("currency"))
                .customerEmail(data.get("customer_email"))
                .reference(data.get("reference"))
                .acceptanceToken(acceptanceToken)
                .acceptPersonalAuth(acceptPersonalAuth)
                .signature(signature)
                .paymentMethod(PaymentMethodBuilder.build(data))
                .build();
    }
}
