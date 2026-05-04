package com.wompi.test.tasks;

import com.wompi.test.abilities.CallWompiApi;
import com.wompi.test.config.WompiEndpoint;
import com.wompi.test.models.request.TransactionRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.annotations.Step;

public class CreateTransaction implements Task {

    private final TransactionRequest request;

    public CreateTransaction(TransactionRequest request) {
        this.request = request;
    }

    public static CreateTransaction withData(TransactionRequest request) {
        return new CreateTransaction(request);
    }

    @Override
    @Step("{0} crea una transacción")
    public <T extends Actor> void performAs(T actor) {
        CallWompiApi ability = actor.abilityTo(CallWompiApi.class);
        actor.attemptsTo(
                Post.to(WompiEndpoint.TRANSACTIONS.getPath())
                        .with(spec -> spec
                                .header("Authorization", ability.getBearer())
                                .header("Content-Type", "application/json")
                                .body(request))
        );
    }
}
