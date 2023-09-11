package co.com.choucair.certification.api.questions;

import co.com.choucair.certification.api.models.ReqresUser;
import co.com.choucair.certification.api.models.ReqresUserResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateUserCreated implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        ReqresUser user = actor.recall("user");
        ReqresUserResponse userResponse = actor.recall("userResponse");

        return user.getName().equals(userResponse.getName()) && user.getJob().equals(userResponse.getJob());
    }

    public static ValidateUserCreated user() {
        return new ValidateUserCreated();
    }
}
