package models;

import com.github.javafaker.Faker;

public class UserFactory {

    public User getRandomUser() {
        Faker faker = new Faker();
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password(8, 24, true, true))
                .build();
    }
    public User getAlreadyRegisteredUser() {
        return User.builder()
                .firstName("John")
                .lastName("Smith")
                .email("jsmith@email.com")
                .password("123456789")
                .build();
    }
}
