package org.example;

public class Main {
    public static void main(String[] args) {
        ApiFacade api = new ApiFacade();

        // Example 1: Chuck Norris joke
        try {
            String joke = api.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Chuck Norris joke:\n" + joke);
        } catch (Exception e) {
            System.out.println("Error fetching joke: " + e.getMessage());
        }

        // Example 2: Currency API (use another public API with JSON response)
        try {
            String rate = api.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "base");
            System.out.println("Base currency:\n" + rate);
        } catch (Exception e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
        }
    }
}