package com.wompi.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.rest.SerenityRest;

public class TransactionStatus implements Question<String> {

    public static TransactionStatus value() {
        return new TransactionStatus();
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse()
                .jsonPath()
                .getString("data.status");
    }
}
