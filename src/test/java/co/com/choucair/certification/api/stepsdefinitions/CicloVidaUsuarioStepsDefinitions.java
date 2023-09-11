package co.com.choucair.certification.api.stepsdefinitions;


import co.com.choucair.certification.api.interactions.SendRequestCreate;
import co.com.choucair.certification.api.interactions.SendRequestDelete;
import co.com.choucair.certification.api.interactions.SendRequestGet;
import co.com.choucair.certification.api.interactions.SendRequestPut;
import co.com.choucair.certification.api.questions.*;
import co.com.choucair.certification.api.tasks.CreateJsonPost;
import co.com.choucair.certification.api.tasks.CreateJsonPut;
import co.com.choucair.certification.api.tasks.LoadUserCreate;
import co.com.choucair.certification.api.tasks.SaveRequest;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static co.com.choucair.certification.api.userinterfaces.EndPoints.END_POINT;
import static co.com.choucair.certification.api.userinterfaces.EndPoints.USER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class CicloVidaUsuarioStepsDefinitions {

    @Before
    public void configurar() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario");
    }

    @Dado("que es un usuario nuevo")
    public void queEsUnUsuarioNuevo(List<Map<String, Object>> table) {
        theActorInTheSpotlight().attemptsTo(CreateJsonPost.withData(table));
    }

    @Cuando("se da inicio al proceso de registro")
    public void seDaInicioAlProcesoDeRegistro() {
        theActorInTheSpotlight().attemptsTo(
                SendRequestCreate.toApi(END_POINT, USER),
                SaveRequest.data()
        );
    }

    @Entonces("^el usuario validara que su registro es exitoso (.*) y (.*)$")
    public void elUsuarioValidaraQueSuRegistroExitosoConstatuYMessage() {
        theActorInTheSpotlight().should(seeThat(ValidateUserCreated.user()));
    }


    @Entonces("^el usuario validara que su registro con statusCode (.*)$")
    public void elUsuarioValidaraQueSuRegistroEsExitosoStatusCode(String statusCode) {
        theActorInTheSpotlight().should(
                seeThat(ValidateUserCreated.user()),
                seeThat(ValidateStatus.code(statusCode)));
    }

    @Dado("^que es un usuario registrado (.*)$")
    public void queEsUnUsuarioRegistrado(String id) {
        theActorInTheSpotlight().attemptsTo(LoadUserCreate.load(id));
    }

    @Cuando("se da inicio al proceso de solicitud de datos")
    public void seDaInicioAlProcesoDeSolicitudDeDatos() {
        theActorInTheSpotlight().attemptsTo(SendRequestGet.toApi(END_POINT, USER));
    }

    @Entonces("el usuario validara que sus datos estan en el sistema")
    public void elUsuarioValidaraQueSusDatosEnElSistema(List<Map<String, Object>> table) {
        theActorInTheSpotlight().should(seeThat(ValidateUserGet.user(table)));
    }

    @Entonces("el usuario validara sus datos en el sistema")
    public void elUsuarioValidaraSusDatosEnElSistema(List<Map<String, Object>> table) {
        theActorInTheSpotlight().should(seeThat(ValidateUserPut.user(table)));
    }

    @Dado("que es un usuario registrado")
    public void queEsUnUsuarioRegistrado(List<Map<String, Object>> table) {
        theActorInTheSpotlight().attemptsTo(CreateJsonPut.withData(table));
    }

    @Cuando("^se da inicio al proceso de actualizacion de datos usuario con id (.*)$")
    public void seDaInicioAlProcesoDeActualizacionDeDatosUsuarioConId(String id) {
        theActorInTheSpotlight().attemptsTo(LoadUserCreate.load(id), SendRequestPut.toApi(END_POINT, USER));
    }

    @Cuando("^se da inicio al proceso de eliminacion del usuario con id (.*)$")
    public void seDaInicioAlProcesoDeEliminacionDelUsuarioConIdId(String id) {
        theActorInTheSpotlight().attemptsTo(LoadUserCreate.load(id),SendRequestDelete.toApi(END_POINT, USER));
    }

    @Entonces("^se validara el statuscode (.*)$")
    public void seValidaraElStatuscodeStatusCode(String statusCode) {
        theActorInTheSpotlight().should(seeThat(ValidateUserDelete.user(statusCode)));
    }


}
