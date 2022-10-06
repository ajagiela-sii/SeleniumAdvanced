package providers;

import com.github.javafaker.Faker;
import models.User;

public class UserFactory {

    public static User getRandomUser() {
        Faker faker = new Faker();
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password(8, 24, true, true))
                .build();
    }
    public static User getAlreadyRegisteredUser() {
        return User.builder()
                .firstName("John")
                .lastName("Smith")
                .email("jsmith@email.com")
                .password("123456789")
                .build();
    }
}
