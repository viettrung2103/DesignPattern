package org.example;

import java.util.ArrayList;
import java.util.List;

public class GuessNumGame extends Game{
    private int prizeNumOfthisRound;
    private int goalScore;
    private List<Player> players;
    private int maxNum;
    private int minNum;


    public GuessNumGame() {
        this.players = new ArrayList<Player>();
        this.maxNum = 50;
        this.minNum = 10;

    }


    @Override
    public void initializeGame(int numberOfPlayers) {
        for ( int i = 0; i < numberOfPlayers; i++){
            String playerName = "Player "+(i+1);
            Player player = new Player(playerName);
            this.players.add(player);
            player.setGame(this);
        }
        this.goalScore = 5;
        this.changePrizeNumOfthisRound();
    }

    public void changePrizeNumOfthisRound() {
        this.prizeNumOfthisRound = Utils.getRandomInt(this.minNum, this.maxNum);
    }

    // if any player reach this goal, win
    public int getGoalScore() {
        return goalScore;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public int getMinNum() {
        return minNum;
    }

    @Override
    public boolean endOfGame() {
        for (Player player : players){
            if (player.canWin()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        Player currentPlayer = this.players.get(player);
        System.out.println(currentPlayer.getGame()+"turn");
        int score = currentPlayer.play();
        if (score == this.prizeNumOfthisRound) {
            currentPlayer.gainScore();
            this.changePrizeNumOfthisRound();
        }

    }

    @Override
    public void displayWinner() {
        for (Player player : players){
            if(player.canWin()){
                System.out.println(player +"is a winner");
            }
        }
    }
}
