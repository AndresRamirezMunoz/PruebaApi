package co.com.choucair.certification.api.tasks;

import co.com.choucair.certification.api.models.ReqresUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

public class CreateJsonPut implements Task {

    private final List<Map<String, Object>> table;

    public CreateJsonPut(List<Map<String, Object>> table) {
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
    }

    public static CreateJsonPut withData(List<Map<String, Object>> table) {
        return Tasks.instrumented(CreateJsonPut.class, table);
    }
}
