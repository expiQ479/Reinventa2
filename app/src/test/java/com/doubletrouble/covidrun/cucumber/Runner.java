package com.doubletrouble.covidrun.cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



    @CucumberOptions(
            plugin = "pretty",
            features = {
                    "src/test/java/com/doubletrouble/covidrun/cucumber/Aceptar_plan/AceptarPlan.feature",
                    "src/test/java/com/doubletrouble/covidrun/cucumber/Ver_info_planes/VerInfoPlanes.feature",
                    "src/test/java/com/doubletrouble/covidrun/cucumber/Ver_Planes/VerPlanes.feature",
            },
            glue = "com.doubletrouble.covidrun.cucumber"
    )
    @RunWith(Cucumber.class)
    public class Runner {

    }

