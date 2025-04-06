package org.example;

public class MasterLevel extends State{
    public MasterLevel(String name, int requiredExperience,Player player) {
        super(name, requiredExperience, player);
    }
    @Override
    void action() {
        System.out.println("MasterLevel action");
    }

    @Override
    void train() {

    }

    @Override
    void meditate() {

    }

    @Override
    void fight() {

    }
}
