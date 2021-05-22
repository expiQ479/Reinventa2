package com.doubletrouble.covidrun.cucumber.smoke_Test;



import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import org.junit.Assert;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
public class Iniciar_Sesion {

    String mesage;

        @Given("^Datos del usuario que quiere iniciar$")
        public void datos_del_usuario_que_quiere_iniciar() throws Throwable {
            System.out.println("El usuario quiere iniciar sesion");
        }

        @When("^Presiono el boton de iniciar sesion$")
        public void presiono_el_boton_de_iniciar_sesion() throws Throwable {
            mesage = "Iniciar Sesion";
        }

        @Then("^Se accede a la app si el usuario existe$")
        public void se_accede_a_la_app_si_el_usuario_existe() throws Throwable {
            Assert.assertEquals("Iniciar Sesion",mesage);
        }

    }

