package org.example;

public class NoviceLevel extends State {
    public NoviceLevel(String name, int requiredExperience,Player player, State nextState) {
        super(name, requiredExperience, player, nextState);
//        super.getPlayer().setLevel(this);
    }
    @Override
    void action() {
        this.getPlayer().getInfo();
//        if(super.hasEnoughExperience()){
//            super.l
//        }
        String[] options = {"train"};
        int option = this.getPlayer().getGame().readUserChoice(options);
        switch (option){
            case 1:
                this.train();
        }
    }

    @Override
    void train() {
        int gainedExperience = 1;
        System.out.println("\nYou are training now!");
        System.out.println("You gain 1 experience!");
        this.getPlayer().gainExperience(gainedExperience);
    }

    @Override
    void meditate() {
        // do nothing
    }

    @Override
    void fight() {
        // do nothing
    }
}
