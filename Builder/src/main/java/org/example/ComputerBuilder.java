package org.example;

public interface ComputerBuilder {
    void buildProcessor();
    void buildOperatingSystem();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicCard();
    Computer getComputer();
}
