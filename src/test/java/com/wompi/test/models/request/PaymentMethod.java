package com.wompi.test.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
}
