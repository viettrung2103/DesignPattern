package org.example;

public class AdvanceLevel extends State{
    public AdvanceLevel(String name, int requiredExperience,Player player, State nextState) {
        super(name, requiredExperience, player, nextState);
    }
    @Override
    void action() {
        this.getPlayer().getInfo();
//        if(super.hasEnoughExperience()){
//            super.l
//        }
        String[] options = {"train", "meditate","fight"};
        int option = this.getPlayer().getGame().readUserChoice(options);
        switch (option){
            case 1:
                this.train();
                break;
            case 2:
                this.meditate();
                break;
            case 3:
                this.fight();
                break;
        }
    }

    @Override
    void train() {
        System.out.println("\nYou are training now!");
        System.out.println("You gain 3 experience!");
        this.getPlayer().gainExperience(3);
    }

    @Override
    void meditate() {
        System.out.println("You are meditating now!");
        int regainHealth = 2;
        System.out.println("You are regaining 1 health point!");
//        this.getPlayer().setCurrentHealth(this.getRequiredExperience()+1);
        this.getPlayer().mediate(regainHealth);
    }

    @Override
    void fight() {
        System.out.println("You are fighting now!");

        int loseHealth = 2;
        this.getPlayer().loseHealth(loseHealth);
        if(this.getPlayer().isAlive());
        this.getPlayer().gainExperience(5);
        System.out.println("You are losing 2 health point!");
        System.out.println("You are gaining 5 experience!");

    }
}
