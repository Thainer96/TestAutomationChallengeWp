package com.wompi.test.stepdefinitions;

import com.wompi.test.questions.MerchantData;
import com.wompi.test.questions.ResponseStatusCode;
import com.wompi.test.tasks.GetMerchant;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class MerchantStepDefinitions {

    @Cuando("consulta el servicio de merchants con su llave pública")
    public void getMerchants() {
        String publicKey = OnStage.theActorInTheSpotlight().recall("publicKey");
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetMerchant.withPublicKey(publicKey)
        );
    }

    @Cuando("consulta el servicio de merchants con llave pública {string}")
    public void getMerchantsWithKey(String publicKey) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetMerchant.withPublicKey(publicKey)
        );
    }

    @Entonces("el servicio de merchants responde exitosamente")
    public void verifyMerchantResponse() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ResponseStatusCode.value(), equalTo(200))
        );
    }

    @Entonces("el servicio de merchants responde con código {int}")
    public void verifyMerchantResponseCode(int expectedCode) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ResponseStatusCode.value(), equalTo(expectedCode))
        );
    }

    @Y("obtiene los tokens de aceptación")
    public void extractAcceptanceTokens() {
        String acceptanceToken = OnStage.theActorInTheSpotlight()
                .asksFor(MerchantData.acceptanceToken());
        String personalAuthToken = OnStage.theActorInTheSpotlight()
                .asksFor(MerchantData.personalAuthToken());

        OnStage.theActorInTheSpotlight().remember("acceptanceToken", acceptanceToken);
        OnStage.theActorInTheSpotlight().remember("personalAuthToken", personalAuthToken);
    }
}
