package org.example;

public class OfficeComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }


    @Override
    public void buildProcessor() {
        this.computer.addComponent(new Processor("Intel 1200U"));
    }

    @Override
    public void buildOperatingSystem() {
        this.computer.addComponent(new OperatingSystem("Window 11"));
    }

    @Override
    public void buildRAM() {
        this.computer.addComponent(new RAM(16));
    }

    @Override
    public void buildHardDrive() {
        this.computer.addComponent(new HardDrive(254));
    }

    @Override
    public void buildGraphicCard() {
        this.computer.addComponent(new GraphicCard("Intel CPU"));
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
