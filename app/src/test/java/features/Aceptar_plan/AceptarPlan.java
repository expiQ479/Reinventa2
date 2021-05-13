package features.Aceptar_plan;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

public class AceptarPlan {


    @RunWith(Cucumber.class)
    public class MyStepDefinitions {

        @Given("^Hay un \"([^\"]*)\" creado$")
        public void hay_un_something_creado(String strArg1) throws Throwable {
            throw new PendingException();
        }

        @When("^Presiono el boton de hecho al lado del plan$")
        public void presiono_el_boton_de_hecho_al_lado_del_plan() throws Throwable {
            throw new PendingException();
        }

        @Then("^Obtengo la experiencia del plan y actualizo el estado del plan a finalizado$")
        public void obtengo_la_experiencia_del_plan_y_actualizo_el_estado_del_plan_a_finalizado() throws Throwable {
            throw new PendingException();
        }

    }
}
