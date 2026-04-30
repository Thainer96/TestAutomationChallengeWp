package com.wompi.test.stepdefinitions;

import com.wompi.test.questions.MerchantData;
import com.wompi.test.questions.ResponseStatusCode;
import com.wompi.test.tasks.GetMerchant;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class MerchantStepDefinitions {

    @When("consulta el servicio de merchants con su llave pública")
    public void getMerchants() {
        String publicKey = OnStage.theActorInTheSpotlight().recall("publicKey");
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetMerchant.withPublicKey(publicKey)
        );
    }

    @Then("el servicio de merchants responde exitosamente")
    public void verifyMerchantResponse() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ResponseStatusCode.value(), equalTo(200))
        );
    }

    @Then("obtiene los tokens de aceptación")
    public void extractAcceptanceTokens() {
        String acceptanceToken = OnStage.theActorInTheSpotlight()
                .asksFor(MerchantData.acceptanceToken());
        String personalAuthToken = OnStage.theActorInTheSpotlight()
                .asksFor(MerchantData.personalAuthToken());

        OnStage.theActorInTheSpotlight().remember("acceptanceToken", acceptanceToken);
        OnStage.theActorInTheSpotlight().remember("personalAuthToken", personalAuthToken);
    }
}
