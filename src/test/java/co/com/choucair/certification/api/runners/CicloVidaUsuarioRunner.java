package co.com.choucair.certification.api.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\ciclo_vida_usuario.feature",
        glue = "co.com.choucair.certification.api.stepsdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class CicloVidaUsuarioRunner {
}
