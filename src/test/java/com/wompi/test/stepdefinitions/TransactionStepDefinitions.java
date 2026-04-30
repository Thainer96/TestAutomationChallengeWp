package com.wompi.test.stepdefinitions;

import com.wompi.test.builders.TransactionBuilder;
import com.wompi.test.models.request.TransactionRequest;
import com.wompi.test.questions.ResponseStatusCode;
import com.wompi.test.tasks.CreateTransaction;
import com.wompi.test.utils.SignatureGenerator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class TransactionStepDefinitions {

    @When("crea una transacción con los siguientes datos:")
    public void createTransaction(DataTable dataTable) {
        Actor actor = OnStage.theActorInTheSpotlight();
        Map<String, String> data = dataTable.asMaps().get(0);

        String acceptanceToken = actor.recall("acceptanceToken");
        String personalAuthToken = actor.recall("personalAuthToken");
        String signature = SignatureGenerator.generate(data);

        TransactionRequest request = TransactionBuilder.fromDataTable(
                data, acceptanceToken, personalAuthToken, signature
        );

        actor.attemptsTo(
                CreateTransaction.withData(request)
        );
    }

    @Then("la transacción se crea exitosamente")
    public void verifyTransactionCreated() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ResponseStatusCode.value(), equalTo(201))
        );
    }
}
