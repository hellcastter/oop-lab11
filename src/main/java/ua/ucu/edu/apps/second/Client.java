package ua.ucu.edu.apps.second;

import lombok.Getter;

@Getter
public class Client {
    private static int prevId = 0;
    private int id;
    private String name;
    private int age;
    private Gender sex;
    private String email;

    public Client(String name, String email, int age, Gender sex) {
        this.id = prevId++;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public Client(String email, int age, Gender sex) {
        this.id = prevId++;
        this.name = email;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }
}
