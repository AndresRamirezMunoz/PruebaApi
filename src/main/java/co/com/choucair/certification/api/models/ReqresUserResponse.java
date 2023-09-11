package co.com.choucair.certification.api.models;

import java.io.Serializable;

public class ReqresUserResponse extends ReqresUser implements Serializable {
    private final String id;
    private final String createdAt;

    public ReqresUserResponse(String name, String job, String id, String createdAt) {
        super(name, job);
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }
}
