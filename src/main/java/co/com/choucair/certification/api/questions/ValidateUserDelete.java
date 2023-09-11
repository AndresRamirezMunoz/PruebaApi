package co.com.choucair.certification.api.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateUserDelete implements Question<Boolean> {

    private final String statusCode;

    public ValidateUserDelete(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode() == Integer.parseInt(statusCode);
    }

    public static ValidateUserDelete user(String statusCode) {
        return new ValidateUserDelete(statusCode);
    }
}
