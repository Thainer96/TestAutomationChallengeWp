package com.wompi.test.stepdefinitions;

import com.wompi.test.abilities.CallWompiApi;
import com.wompi.test.config.Environment;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class SetupStepDefinitions {

    @Given("un usuario en ambiente de pruebas {string}")
    public void setupEnvironment(String environment) {
        EnvironmentVariables envVars = SystemEnvironmentVariables.createEnvironmentVariables();
        String baseUrl = envVars.getProperty("environments." + environment.toLowerCase() + ".base.url",
                envVars.getProperty("environments.default.base.url"));

        String publicKey = Environment.getPublicKey();

        Actor actor = OnStage.theActorCalled("usuario");
        actor.whoCan(CallAnApi.at(baseUrl));
        actor.whoCan(CallWompiApi.withCredentials(baseUrl, publicKey));
        actor.remember("publicKey", publicKey);
        actor.remember("baseUrl", baseUrl);
        actor.remember("environment", environment);
    }
}
