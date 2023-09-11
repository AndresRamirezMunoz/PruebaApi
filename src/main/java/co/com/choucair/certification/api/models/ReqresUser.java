package co.com.choucair.certification.api.models;

import java.io.Serializable;

public class ReqresUser implements Serializable {
    private final String name;
    private final String job;


    public ReqresUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }


}
