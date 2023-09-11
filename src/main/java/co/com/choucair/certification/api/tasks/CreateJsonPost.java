package co.com.choucair.certification.api.tasks;

import co.com.choucair.certification.api.models.ReqresUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

public class CreateJsonPost implements Task {

    private final List<Map<String, Object>> table;

    public CreateJsonPost(List<Map<String, Object>> table) {
        this.table = table;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ObjectMapper mapper = new ObjectMapper();
        String name = table.get(0).get("name").toString();
        String job = table.get(0).get("job").toString();
        try {
            actor.remember("user", new ReqresUser(name, job));
            actor.remember("userJson", mapper.writeValueAsString(new ReqresUser(name, job)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        /*+

        ObjectMapper mapper = new ObjectMapper();
        String name = table.get(0).get("name").toString();
        String salary = table.get(0).get("salary").toString();
        String age = table.get(0).get("age").toString();
        try {
            actor.remember("user", mapper.writeValueAsString(new User(name, salary, age)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

         */
    }

    public static CreateJsonPost withData(List<Map<String, Object>> table) {
        return Tasks.instrumented(CreateJsonPost.class, table);
    }
}
