package com.wompi.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.rest.SerenityRest;

public class MerchantData implements Question<String> {

    private final String jsonPath;

    private MerchantData(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public static MerchantData field(String jsonPath) {
        return new MerchantData(jsonPath);
    }

    public static MerchantData acceptanceToken() {
        return new MerchantData("data.presigned_acceptance.acceptance_token");
    }

    public static MerchantData personalAuthToken() {
        return new MerchantData("data.presigned_personal_data_auth.acceptance_token");
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse()
                .jsonPath()
                .getString(jsonPath);
    }
}
