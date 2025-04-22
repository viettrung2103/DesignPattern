package org.example;

public class ComputerDirector {

    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder){
        this.builder = builder;
    }

    public void setComputerBuiilder(ComputerBuilder builder){
        this.builder = builder;
    }

    public void buildSimpleComputer() {
        builder.buildGraphicCard();
        builder.buildHardDrive();
        builder.buildOperatingSystem();
        builder.buildProcessor();
        builder.buildRAM();

    }

    public void buildHighEndComputer(){
        builder.buildGraphicCard();
        builder.buildGraphicCard();
        builder.buildOperatingSystem();
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildHardDrive();
    }
}
