package com.doubletrouble.covidrun.cucumber.Ver_info_planes;
import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class VerInfoPlanes {
    String mesage;
    @Given("^Hay un plan$")
    public void hay_un_plan() throws Throwable {
        System.out.println("Plan");
    }

    @When("^Presiono el boton de ver la informacion del plan$")
    public void presiono_el_boton_de_ver_la_informacion_del_plan() throws Throwable {
        mesage = "Prueba";
    }

    @Then("^Se me muestran la informacion del plan que quiero ver$")
    public void se_me_muestran_la_informacion_del_plan_que_quiero_ver() throws Throwable {
        Assert.assertEquals("Prueba",mesage);
    }

}
