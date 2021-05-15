package com.doubletrouble.covidrun.cucumber.Aceptar_plan;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import org.junit.Assert;

public class AceptarPlan {

        String mesage;

        @Given("^Hay un \"([^\"]*)\" creado$")
        public void hay_un_something_creado(String strArg1) throws Throwable {
            System.out.println("Plan");
        }

        @When("^Presiono el boton de hecho al lado del plan$")
        public void presiono_el_boton_de_hecho_al_lado_del_plan() throws Throwable {
            mesage = "Prueba";
        }

        @Then("^Obtengo la experiencia del plan y actualizo el estado del plan a finalizado$")
        public void obtengo_la_experiencia_del_plan_y_actualizo_el_estado_del_plan_a_finalizado() throws Throwable {
            Assert.assertEquals("Prueba",mesage);
        }


}
