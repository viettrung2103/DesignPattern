package org.example;

public class Player {
    private String name;
    private int score;
    private GuessNumGame game;
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void gainScore(){
        this.score++;
    }

    public GuessNumGame getGame() {
        return game;
    }
    public void setGame(GuessNumGame game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean canWin(){
        return this.score == this.game.getGoalScore();
    }

    public int play(){
        int gameMaxNum = this.game.getMaxNum();
        int gameMinNum = this.game.getMinNum();
        int guessNum = Utils.getRandomInt(gameMinNum, gameMaxNum);
        System.out.println(this.getGame()+" guess number: "+guessNum);
//        System.out.println();
        return Utils.getRandomInt(gameMinNum, gameMaxNum);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
