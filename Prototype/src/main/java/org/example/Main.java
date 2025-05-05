package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecommendationRegistry registry = new RecommendationRegistry();
        Scanner scanner = new Scanner(System.in);

        // Setup initial prototypes
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937);
        Recommendation teen = new Recommendation("Teen Readers");
        teen.addBook(book1);
        registry.register("Teen", teen);

        Book book2 = new Book("Dune", "Frank Herbert", "Science Fiction", 1965);
        Recommendation adult = new Recommendation("Adult Readers");
        adult.addBook(book2);
        registry.register("Adult", adult);

        while (true) {
            System.out.println("\n1. View Recommendations\n2. Clone and Modify\n3. Exit");
            System.out.print("Choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    for (var entry : registry.getPrototypes().entrySet()) {
                        System.out.println("\n[" + entry.getKey() + "]\n" + entry.getValue());
                    }
                    break;

                case "2":
                    System.out.print("Clone which prototype (Teen/Adult)? ");
                    String key = scanner.nextLine();
                    try {
                        Recommendation clone = registry.clone(key);
                        System.out.print("New target audience name: ");
                        clone.setTargetAudience(scanner.nextLine());

                        while (true) {
                            System.out.print("(a)dd book, (r)emove book, (d)one: ");
                            String action = scanner.nextLine();
                            if (action.equals("a")) {
                                System.out.print("Title: ");
                                String title = scanner.nextLine();
                                System.out.print("Author: ");
                                String author = scanner.nextLine();
                                System.out.print("Genre: ");
                                String genre = scanner.nextLine();
                                System.out.print("Year: ");
                                int year = Integer.parseInt(scanner.nextLine());
                                clone.addBook(new Book(title, author, genre, year));
                            } else if (action.equals("r")) {
                                System.out.print("Book title to remove: ");
                                clone.removeBook(scanner.nextLine());
                            } else if (action.equals("d")) {
                                break;
                            }
                        }

                        registry.register(clone.getTargetAudience(), clone);
                        System.out.println("New recommendation saved.");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "3":
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}