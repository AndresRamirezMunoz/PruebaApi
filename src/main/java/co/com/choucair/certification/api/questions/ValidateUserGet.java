package co.com.choucair.certification.api.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

public class ValidateUserGet implements Question<Boolean> {

    List<Map<String, Object>> table;

    public ValidateUserGet(List<Map<String, Object>> table) {
        this.table = table;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String id = table.get(0).get("id").toString();
        String email = table.get(0).get("email").toString();
        String firstName = table.get(0).get("firstName").toString();
        String lastName = table.get(0).get("lastName").toString();
        String response = SerenityRest.lastResponse().jsonPath().get("data").toString();

        return response.contains(id) && response.contains(email) &&
                response.contains(firstName) && response.contains(lastName);
    }

    public static ValidateUserGet user(List<Map<String, Object>> table) {
        return new ValidateUserGet(table);
    }
}
