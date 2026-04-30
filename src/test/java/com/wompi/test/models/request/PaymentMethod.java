package com.wompi.test.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentMethod {

    private String type;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("payment_description")
    private String paymentDescription;

    @JsonProperty("sandbox_status")
    private String sandboxStatus;

    @JsonProperty("user_type")
    private String userType;

    public PaymentMethod() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public String getSandboxStatus() {
        return sandboxStatus;
    }

    public void setSandboxStatus(String sandboxStatus) {
        this.sandboxStatus = sandboxStatus;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
