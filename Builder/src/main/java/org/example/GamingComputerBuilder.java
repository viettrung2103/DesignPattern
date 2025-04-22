package org.example;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }
    @Override
    public void buildProcessor() {
        this.computer.addComponent(new Processor("Intel Xeon 23"));
    }

    @Override
    public void buildOperatingSystem() {
        this.computer.addComponent(new OperatingSystem("Window 11"));
    }

    @Override
    public void buildRAM() {
        this.computer.addComponent(new RAM(32));
    }

    @Override
    public void buildHardDrive() {
        this.computer.addComponent(new HardDrive(1000));
    }

    @Override
    public void buildGraphicCard() {
        this.computer.addComponent(new GraphicCard("NVIDIA TITAN 1080"));
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
