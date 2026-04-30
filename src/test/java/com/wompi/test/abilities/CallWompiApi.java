package com.wompi.test.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class CallWompiApi implements Ability {

    private final String baseUrl;
    private final String bearer;

    private CallWompiApi(String baseUrl, String bearer) {
        this.baseUrl = baseUrl;
        this.bearer = bearer;
    }

    public static CallWompiApi withCredentials(String baseUrl, String publicKey) {
        return new CallWompiApi(baseUrl, "Bearer " + publicKey);
    }

    public String getBearer() {
        return bearer;
    }

    public CallAnApi asCallAnApi() {
        return CallAnApi.at(baseUrl);
    }

    @Override
    public String toString() {
        return "call the Wompi API at " + baseUrl;
    }
}
