package ua.ucu.edu.apps.first;

public class Main {
    public static void main(String[] args) {
        User user = User
                .builder()
                .name("Victor")
                .gender(Gender.MALE)
                .occupation("Student")
                .build();

        System.out.println(user);
    }
}