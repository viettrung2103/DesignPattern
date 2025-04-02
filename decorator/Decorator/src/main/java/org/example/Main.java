package org.example;

public class Main {
    public static void main(String[] args) {

        String message = "Hello World!";

        Printer basicPrinter = new BasicPrinter();
        Printer xmlPrinter = new XMLPrinterDecorator(basicPrinter);
        Printer encryptingPrinter = new EncryptPrinterDecorator(basicPrinter);
        Printer decryptingPrinter = new DecryptPrinterDecorator(basicPrinter);

        System.out.println("Original Message:");
        basicPrinter.print(message);

        System.out.println("XML Formatted Message:");
        xmlPrinter.print(message);

        System.out.println("Encrypted Message:");
        encryptingPrinter.print(message);

        String encryptedMessage = ((EncryptPrinterDecorator) encryptingPrinter).encrypt(message);

        System.out.println("Decrypted Message:");
        decryptingPrinter.print(encryptedMessage);
    }
}