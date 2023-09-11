package co.com.choucair.certification.api.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

public class ValidateUserPut implements Question<Boolean> {

    List<Map<String, Object>> table;

    public ValidateUserPut(List<Map<String, Object>> table) {
        this.table = table;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String id = table.get(0).get("name").toString();
        String email = table.get(0).get("job").toString();
        String response = SerenityRest.lastResponse().jsonPath().get().toString();
        return response.contains(id) && response.contains(email) ;
    }

    public static ValidateUserPut user(List<Map<String, Object>> table) {
        return new ValidateUserPut(table);
    }
}
