package org.example;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingBuilder);
        director.buildSimpleComputer();
        Computer computer = gamingBuilder.getComputer();
        System.out.println("gaming Computer: "+computer);

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.setComputerBuiilder(officeBuilder);
        director.buildHighEndComputer();
        Computer officeComputer = officeBuilder.getComputer();
        System.out.println("Office: "+officeComputer);

    }
}