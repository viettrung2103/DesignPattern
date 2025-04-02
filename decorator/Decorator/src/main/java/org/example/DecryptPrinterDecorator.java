package org.example;

public class DecryptPrinterDecorator extends PrinterDecorator {
    private static final int SHIFT = 3;

    public DecryptPrinterDecorator(Printer printer) {
        super(printer);
    }

    // by deshift each character in the String by SHIFT amount in the unicode value

    public String decrypt(String message) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            decrypted.append((char) (c - SHIFT));
        }
        return decrypted.toString();
    }

    private String stripXmlTags(String message) {
        return message.replaceAll("<.*?>", "");
    }

    @Override
    public void print(String message) {
        String strippedMessage = stripXmlTags(message);
        String decryptedMessage = decrypt(strippedMessage);
        super.print(decryptedMessage);
    }
}