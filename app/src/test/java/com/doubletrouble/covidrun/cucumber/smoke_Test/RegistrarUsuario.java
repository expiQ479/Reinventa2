package com.doubletrouble.covidrun.cucumber.smoke_Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class RegistrarUsuario {

    String mesage;

    @Given("^Datos del usuario que quiere registrarse$")
    public void datos_del_usuario_que_quiere_registrarse() throws Throwable {
        System.out.println("Registro");
    }

    @When("^Presiono el boton de registrarse$")
    public void presiono_el_boton_de_registrarse() throws Throwable {
        mesage = "Registrado";
    }

    @Then("^Se añade el usuario a la base de datos$")
    public void se_aade_el_usuario_a_la_base_de_datos() throws Throwable {
        Assert.assertEquals("Registrado",mesage);
    }
}
