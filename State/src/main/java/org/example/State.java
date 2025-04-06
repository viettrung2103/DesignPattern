package org.example;

public abstract class State {
    private Player player;
    private String name;
    private int requiredExperience;
    private State nextState;

    public State(String name, int requiredExperience,Player player, State nextState) {
        this.player = player;
        this.name = name;
        this.requiredExperience = requiredExperience;
        this.nextState = nextState;
        this.player.setLevel(this);
    }

    public State(String name, int requiredExperience,Player player) {
        this(name, requiredExperience, player, null);
    }


    public boolean hasEnoughExperience(){
        return this.player.getExperience() >= requiredExperience;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(int requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    abstract void action();
    abstract void train();
    abstract void meditate();
    abstract void fight();
}
