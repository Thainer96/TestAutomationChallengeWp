package com.wompi.test.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public TransactionRequest() {
    }

    public int getAmountInCents() {
        return amountInCents;
    }

    public void setAmountInCents(int amountInCents) {
        this.amountInCents = amountInCents;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAcceptanceToken() {
        return acceptanceToken;
    }

    public void setAcceptanceToken(String acceptanceToken) {
        this.acceptanceToken = acceptanceToken;
    }

    public String getAcceptPersonalAuth() {
        return acceptPersonalAuth;
    }

    public void setAcceptPersonalAuth(String acceptPersonalAuth) {
        this.acceptPersonalAuth = acceptPersonalAuth;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
