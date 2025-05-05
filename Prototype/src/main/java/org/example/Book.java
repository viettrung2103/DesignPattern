package org.example;

public class Book implements Cloneable {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone(); // shallow is okay since fields are immutable
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return String.format("\"%s\" by %s (%s, %d)", title, author, genre, publicationYear);
    }
}