package com.wompi.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.annotations.Step;

public class GetMerchant implements Task {

    private final String publicKey;

    public GetMerchant(String publicKey) {
        this.publicKey = publicKey;
    }

    public static GetMerchant withPublicKey(String publicKey) {
        return new GetMerchant(publicKey);
    }

    @Override
    @Step("{0} consulta el merchant con su llave pública")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/merchants/" + publicKey)
        );
    }
}
