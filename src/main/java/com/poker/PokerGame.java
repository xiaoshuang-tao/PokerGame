package com.poker;

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

    private Player getWinner() throws Exception {
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
        String result = winner == null ? "Tie." : winner.printWinningMessage();
        System.out.println(result);
        return result;
    }
}
