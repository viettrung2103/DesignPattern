package org.example;

import java.util.Scanner;

public class Game {
    public Player player;
    private static Scanner scanner = new Scanner(System.in);

    public Game(){

        this.player = new Player("playerOne",this,10);
    State masterLevel = new MasterLevel("Master",0,player);
    State advancedLevel = new AdvanceLevel("Advanced",10,player,masterLevel);
    State intermediateLevel = new IntermediateLevel("Intermediate",6,player,advancedLevel);
    State noviceLevel = new NoviceLevel("Novice",3,player,intermediateLevel);
        // intermediate level
    // advanced level
    // master level
    }

//    public Game(){
//        player = new Player(this);
//    }


    public void play(){
        while (!canEnd()){
            if (!this.player.isAlive()){
                System.out.println("You are dead!");
                System.out.println("End game");
                break;
            }
            this.player.action();
        }
        endGame();
    }

    public int readUserChoice(String[] options) {
        // print options
        System.out.println("\nSelect an option:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        // read user input
        return scanner.nextInt();
    }

    public boolean canEnd(){
        return this.player.getLevel().getNextState() == null;
    }

    public void endGame(){
        System.out.println("You have reach the end of the game!");
        System.out.println("You have won!");
    }

}
