package org.example;

public class Main {
    public static void main(String[] args) {
        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

        // Set the date
        dateAdapter.setDay(21);
        dateAdapter.setMonth(3); // March
        dateAdapter.setYear(2025);

        System.out.println("Initial Date: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());

        dateAdapter.advanceDays(21);

        System.out.println("New Date: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());

    }
}