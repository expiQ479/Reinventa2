package features;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



    @CucumberOptions(
            plugin = "pretty",
            features = {
                    "src/test/java/features/Aceptar_plan/AceptarPlan.feature",
                    "src/test/java/features/Ver_info_planes/VerInfoPlanes.feature",
                    "src/test/java/features/Ver_Planes/VerPlanes.feature",
            },
            glue = "feature.step_definitions"
    )
    @RunWith(Cucumber.class)
    public class Runner {

    }

