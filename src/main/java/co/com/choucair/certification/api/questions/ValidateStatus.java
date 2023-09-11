package co.com.choucair.certification.api.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateStatus implements Question<Boolean> {


    private final String statusCode;

    public ValidateStatus(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode() == Integer.parseInt(statusCode);
    }

    public static Question<Boolean> code(String statusCode) {
        return new ValidateStatus(statusCode);
    }
}
