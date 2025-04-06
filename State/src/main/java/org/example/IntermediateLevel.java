package org.example;

public class IntermediateLevel extends State {
    public IntermediateLevel(String name, int requiredExperience,Player player, State nextState) {
        super(name, requiredExperience, player, nextState);
    }

    @Override
    void action() {
        this.getPlayer().getInfo();
//        if(super.hasEnoughExperience()){
//            super.l
//        }
        String[] options = {"train", "meditate"};
        int option = this.getPlayer().getGame().readUserChoice(options);
        switch (option){
            case 1:
                this.train();
                break;
            case 2:
                this.meditate();
        }
    }

    @Override
    void train() {
        System.out.println("\nYou are training now!");
        System.out.println("You gain 2 experience!");
        this.getPlayer().gainExperience(2);
    }

    @Override
    void meditate() {
        System.out.println("You are meditating now!");
        int regainHealth = 1;
        System.out.println("You are regaining 1 health point!");
//        this.getPlayer().setCurrentHealth(this.getRequiredExperience()+1);
        this.getPlayer().mediate(regainHealth);
    }

    @Override
    void fight() {

    }
}
