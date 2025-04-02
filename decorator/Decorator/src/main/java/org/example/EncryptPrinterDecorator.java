package org.example;

import org.example.Printer;
import org.example.PrinterDecorator;

public class EncryptPrinterDecorator extends PrinterDecorator {
    private static final int SHIFT = 3;

    public EncryptPrinterDecorator(Printer printer) {
        super(printer);
    }

    // by shift each character in the String by SHIFT amount in the unicode value
    public String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            encrypted.append((char) (c + SHIFT));
        }
        return encrypted.toString();
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        super.print(encryptedMessage);
    }
}