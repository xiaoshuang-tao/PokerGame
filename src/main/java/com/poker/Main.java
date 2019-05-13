package com.poker;

public class Main {
    public static void main(String[] args) throws Exception{
        PokerGame game = PokerGame.initGame();
        game.showHand();
        game.printGameResult();
    }
}
