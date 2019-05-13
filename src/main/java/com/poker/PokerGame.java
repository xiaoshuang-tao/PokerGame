package com.poker;

import com.poker.hand.IHand;
import com.poker.hand.analyzer.IHandAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PokerGame {

    private Player player1;
    private Player player2;
    private static PokerGame game = null;

    public PokerGame(Player player1, Player player2) throws Exception {
        if (player1 != null && player2 != null) {
            this.player1 = player1;
            this.player2 = player2;
        }else {
            throw new Exception("Play can not be null");
        }
    }

    private Player getWinner(){
        switch (player1.compareTo(player2)) {
            case -1:
                return player2;
            case 0:
                return null;
            default:
                return player1;
        }
    }

    public String printGameResult(){
        Player winner = getWinner();
        String result = winner == null ? "Tie." : getWinningMessage();
        System.out.println(result);
        return result;
    }

    private String getWinningMessage(){
        IHand p1Hand = player1.getHand();
        IHand p2Hand = player2.getHand();
        if(p1Hand.getType().getRank()>p2Hand.getType().getRank()){
            return player1.getName()+" win. - with "+p1Hand.getType().getName()+": "+p1Hand.getContent();
        }else if(p1Hand.getType().getRank()<p2Hand.getType().getRank()){
            return player2.getName()+" win. - with "+p2Hand.getType().getName()+": "+p2Hand.getContent();
        }else{
            Player winner = this.getWinner();
            String higherCardMessage = winner.getHand().getRankingMessage(player1,player2);
            return winner.getName()+" win. - with "+winner.getHand().getType().getName()+": "+higherCardMessage;
        }
    }

    private static List<Card> getAllCards(){
        List<Card> cards = new ArrayList<>();
        for(SuitEnum suit:SuitEnum.values()) {
            cards.add(new Card(suit,"2"));
            cards.add(new Card(suit,"3"));
            cards.add(new Card(suit,"4"));
            cards.add(new Card(suit,"5"));
            cards.add(new Card(suit,"6"));
            cards.add(new Card(suit,"7"));
            cards.add(new Card(suit,"8"));
            cards.add(new Card(suit,"9"));
            cards.add(new Card(suit,"T"));
            cards.add(new Card(suit,"J"));
            cards.add(new Card(suit,"Q"));
            cards.add(new Card(suit,"K"));
            cards.add(new Card(suit,"A"));
        }
        return cards;
    }

    private static List<Card> getFiveRandomCards(List<Card> cards){
        List<Card> result = new ArrayList<>();
        for(int i = 0; i< IHandAnalyzer.CARDS_NUMBER; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, cards.size());
            result.add(cards.get(randomNum));
            cards.remove(randomNum);
        }
        return result;
    }

    public static PokerGame initGame() throws Exception {
        if(game ==null) {
            List<Card> cards = getAllCards();
            List<Card> playerOneCards = getFiveRandomCards(cards);
            List<Card> playerTwoCards = getFiveRandomCards(cards);
            Player p1 = new Player("Black", playerOneCards);
            Player p2 = new Player("White", playerTwoCards);
            game = new PokerGame(p1,p2);
        }
        return game;
    }

    public void showHand(){
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }

}
