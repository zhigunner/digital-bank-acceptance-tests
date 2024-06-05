package co.wedevx.digitalbank.automation.ui.utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

// JavaFaker is a library that can be used to generate a wide array of real-looking data from addresses to popular culture references.

public class MockData {

    private FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"), new RandomService());


    public Map<String,String> generateRandomNameAndEmail() {
        String name = fakeValuesService.bothify(new Faker().name().firstName());
        String email = fakeValuesService.bothify(name + "###@gmail.com");

        Map<String, String> data = new HashMap<>();
        data.put("Name:", name.toLowerCase());
        data.put("email:", email.toLowerCase());

        return data;
    }

    public String generateRandomSSN() {
        String ssn = String.format("%9d", new Random().nextInt(1000000000));
        return ssn;
    }

    public static void main(String[] args) {
        MockData mockData = new MockData();
        Map<String, String> data = mockData.generateRandomNameAndEmail();
        System.out.println(data.get("Name: "));
        System.out.println(data.get("email: "));

        System.out.println(mockData.generateRandomSSN());
    }
}
