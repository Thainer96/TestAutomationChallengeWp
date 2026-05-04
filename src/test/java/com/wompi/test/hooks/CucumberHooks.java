package com.wompi.test.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CucumberHooks {

    private static final Logger logger = LogManager.getLogger(CucumberHooks.class);

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        SerenityRest.reset();
        logger.info("Stage configurado para el escenario");
    }
}
