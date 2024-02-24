package ru.netology.web;

import com.github.javafaker.Faker;
import lombok.Value;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int addDays) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
//        Faker faker = new Faker(new Locale(locale)); //<- с этим кодом сборка CI падает
//        String city = faker.address().cityName().;
        String[] city = new String[]{"Москва", "Новосибирск", "Улан-Удэ", "Омск", "Магадан", "Якутск", "Владивосток", "Воронеж", "Казань"};
        return city[new Random().nextInt(city.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String local) {
            UserInfo user = new UserInfo(generateCity(local), generateName(local), generatePhone(local));
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}