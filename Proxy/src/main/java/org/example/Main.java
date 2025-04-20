package org.example;

public class Main {
    public static void main(String[] args) {
//        AccessControlService accessControlService
        Library library = new Library();

        User alice = new User("Alice");
        User bob = new User("Bob");

//        Document unprotectedDocument = new

        library.addUnprotectedDocument("doc1", "This is an unprotected document.");
        library.addProtectedDocument(alice,"doc2");

        try {

            System.out.println("Access Unprotected Document");
            System.out.println("Alice access document doc1 "+library.getDocument("doc1").getContent(alice));
            System.out.println("Bob access document doc1 "+library.getDocument("doc1").getContent(bob));

            System.out.println("Access Protected Document");
            System.out.println("with access permit, Alice access document doc2 "+ library.getDocument("doc2").getContent(alice));
            System.out.println("without access permit, Bob access document doc2 "+library.getDocument("doc2").getContent(bob));


        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}