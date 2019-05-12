package com.poker;

import com.poker.hand.HandUtil;
import com.poker.hand.IHand;

public class PokerGame {

    private Player player1;
    private Player player2;

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

    public String printGameResult() throws Exception {
        Player winner = getWinner();
        String result = winner == null ? "Tie." : getWinningMessage();
        System.out.println(result);
        return result;
    }

    private String getWinningMessage() throws Exception {
        IHand p1Hand = player1.getHand();
        IHand p2Hand = player2.getHand();
        if(p1Hand.getType().getRank()>p2Hand.getType().getRank()){
            return player1.getName()+" win. - with "+p1Hand.getType().getName()+": "+p1Hand.getContent();
        }else if(p1Hand.getType().getRank()<p2Hand.getType().getRank()){
            return player2.getName()+" win. - with "+p2Hand.getType().getName()+": "+p2Hand.getContent();
        }else{
            Player winner = this.getWinner();
            String hignerCardMessage = HandUtil.getHigherCardMessage(winner,player1,player2);
            return winner.getName()+" win. - with "+winner.getHand().getType().getName()+": "+hignerCardMessage;
        }
    }
}
