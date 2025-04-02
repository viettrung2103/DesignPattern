package org.example;

public class XMLPrinterDecorator extends PrinterDecorator{
    public XMLPrinterDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message){
        String startString = "<message>";
        String endString = "</message>";
        String formattedString =startString+message+endString;
        super.print(formattedString);
    }
}
