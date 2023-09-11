package co.com.choucair.certification.api.interactions;


import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class SendRequestPut implements Interaction {

    private final String endPoint;
    private final String service;

    public SendRequestPut(String endPoint, String service) {
        this.endPoint = endPoint;
        this.service = service;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String newService = service.concat(actor.recall("id").toString());
        SerenityRest.given().
                relaxedHTTPSValidation()
                .baseUri(endPoint)
                .contentType("application/json").header("Content-Type", "application/json")
                .body(actor.recall("userJson").toString())
                .basePath(newService)
                .when().put();
    }

    public static SendRequestPut toApi(String endPoint, String service) {
        return Tasks.instrumented(SendRequestPut.class, endPoint, service);
    }
}
