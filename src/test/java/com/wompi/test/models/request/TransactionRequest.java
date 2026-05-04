package com.wompi.test.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionRequest {

    @JsonProperty("amount_in_cents")
    private int amountInCents;

    private String currency;

    @JsonProperty("customer_email")
    private String customerEmail;

    private String reference;

    private String signature;

    @JsonProperty("acceptance_token")
    private String acceptanceToken;

    @JsonProperty("accept_personal_auth")
    private String acceptPersonalAuth;

    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;
}
