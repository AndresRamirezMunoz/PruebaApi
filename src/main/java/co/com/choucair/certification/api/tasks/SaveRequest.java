package co.com.choucair.certification.api.tasks;

import co.com.choucair.certification.api.models.ReqresUserResponse;
import co.com.choucair.certification.api.utils.DataSave;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SaveRequest implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        String name = SerenityRest.lastResponse().jsonPath().get("name").toString();
        String job = SerenityRest.lastResponse().jsonPath().get("job").toString();
        String id = SerenityRest.lastResponse().jsonPath().get("id").toString();
        String createdAt = SerenityRest.lastResponse().jsonPath().get("createdAt").toString();
        ReqresUserResponse user = new ReqresUserResponse(name, job, id, createdAt);
        actor.remember("userResponse", user);
        DataSave.save(user);
    }

    public static SaveRequest data() {
        return Tasks.instrumented(SaveRequest.class);
    }
}
