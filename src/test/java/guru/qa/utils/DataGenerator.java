package guru.qa.utils;

import com.github.javafaker.Faker;

public class DataGenerator {

    Faker faker = new Faker();

    public String getRandomSearchValue() {

        return faker.country().name();
    }
}
