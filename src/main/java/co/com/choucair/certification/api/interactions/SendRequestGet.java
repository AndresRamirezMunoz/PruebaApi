package co.com.choucair.certification.api.interactions;


import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class SendRequestGet implements Interaction {

    private final String endPoint;
    private final String service;

    public SendRequestGet(String endPoint, String service) {
        this.endPoint = endPoint;
        this.service = service;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given().
                relaxedHTTPSValidation()
                .baseUri(endPoint)
                .contentType("application/json").header("Content-Type", "application/json")
                .basePath(service.concat(actor.recall("id")))
                .when().get();
    }

    public static SendRequestGet toApi(String endPoint, String service) {
        return Tasks.instrumented(SendRequestGet.class, endPoint, service);
    }
}
