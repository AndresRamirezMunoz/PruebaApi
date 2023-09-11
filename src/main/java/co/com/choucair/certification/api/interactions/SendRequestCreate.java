package co.com.choucair.certification.api.interactions;


import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class SendRequestCreate implements Interaction {

    private final String endPoint;
    private final String service;

    public SendRequestCreate(String endPoint, String service) {
        this.endPoint = endPoint;
        this.service = service;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given().
                relaxedHTTPSValidation()
                .baseUri(endPoint)
                .contentType("application/json").header("Content-Type", "application/json")
                .body(actor.recall("userJson").toString())
                .basePath(service)
                .when().post();
    }

    public static SendRequestCreate toApi(String endPoint, String service) {
        return Tasks.instrumented(SendRequestCreate.class, endPoint, service);
    }
}
