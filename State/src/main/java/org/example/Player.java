package org.example;

public class Player {

    private String name;
//    private int level;
    private int experience;
    private int maxHealth;
    private int currentHealth;
    private State level;
    private Game game;

    public Player(String name,Game game,int maxHealth) {
        this.name = name;
        this.experience = 0;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
//        this.level = level;
        this.game = game;

    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getLevel() {
        return this.level;
    }

    public void setLevel(State level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void gainExperience() {
        this.setExperience(this.getExperience() + 1);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        if (currentHealth > maxHealth) {}
        this.currentHealth = currentHealth;
    }

//    public

//    public State getState() {
//        return this.level;
//    }
//
//    public void setState(State state) {
//        this.state = state;
//    }

    public boolean canLevelUp() {
        return this.level.hasEnoughExperience();
    }

    public void gainExperience(int experience) {
        this.setExperience(this.getExperience() + experience);
    }

    public void levelUp() {
        if (canLevelUp()){
            State nextLevel = this.level.getNextState();
            System.out.println("You have level up to "+ nextLevel.getName()+"!");
            this.level = nextLevel;
            this.experience = 0;
            this.level.setPlayer(this);
        }
    }

    public void  train(){
        this.level.train();
    }

    public void mediate(int regainHealth){
//        this.level.meditate();
        if (this.currentHealth+regainHealth <= maxHealth) {
            this.currentHealth += regainHealth;
        } else{
            System.out.println("Your health is too high!");
        }
    }

    public void loseHealth(int lostHealth){
        if (this.currentHealth-lostHealth >= 0) {
            this.currentHealth -= lostHealth;
        }
        else this.currentHealth = 0;
    }

    public boolean isAlive(){
        return this.currentHealth > 0;
    }


    public void fight(){
        this.level.fight();
    }

    public void action(){
        if(this.canLevelUp()){
            this.levelUp();
        }else {

        this.level.action();
        }
    }

    public void getInfo(){
        System.out.println("Your Health: " + this.getCurrentHealth());
        System.out.println("Your Experience: " + this.getExperience());
    }

}
