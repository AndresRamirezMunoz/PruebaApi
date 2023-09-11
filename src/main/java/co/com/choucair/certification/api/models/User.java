package co.com.choucair.certification.api.models;


public class User {

    private final String name;
    private final String salary;
    private final String age;


    public User(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    public String getAge() {
        return age;
    }
}
