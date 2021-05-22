package com.doubletrouble.covidrun.cucumber.Ver_Planes;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class VerPlanes {
    String mesage;
    @Given("^Hay planes hechos$")
    public void hay_planes_hechos() throws Throwable {
        System.out.println("Plan");
    }

    @When("^Presiono el boton de ver los planes$")
    public void presiono_el_boton_de_ver_los_planes() throws Throwable {
        mesage = "Ver planes";
    }

    @Then("^Se me muestran todos los planes$")
    public void se_me_muestran_todos_los_planes() throws Throwable {
        Assert.assertEquals("Ver planes",mesage);
    }

}
