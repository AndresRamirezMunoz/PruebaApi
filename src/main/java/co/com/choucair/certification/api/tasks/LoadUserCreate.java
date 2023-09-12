package co.com.choucair.certification.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class LoadUserCreate implements Task {

    private final String id;

    public LoadUserCreate(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        //ReqresUserResponse user = DataSave.read();
        //actor.remember("userResponse", user);
        actor.remember("id", id);

    }

    public static LoadUserCreate load(String id) {
        return Tasks.instrumented(LoadUserCreate.class, id);
    }
}
