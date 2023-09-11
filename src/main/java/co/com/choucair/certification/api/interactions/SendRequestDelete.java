package co.com.choucair.certification.api.interactions;


import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class SendRequestDelete implements Interaction {

    private final String endPoint;
    private final String service;

    public SendRequestDelete(String endPoint, String service) {
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
                .basePath(newService)
                .when().delete();
    }

    public static SendRequestDelete toApi(String endPoint, String service) {
        return Tasks.instrumented(SendRequestDelete.class, endPoint, service);
    }
}
