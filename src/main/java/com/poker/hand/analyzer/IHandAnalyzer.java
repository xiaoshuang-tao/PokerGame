package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.HandUtil;
import com.poker.hand.IHand;

import java.util.List;

public interface IHandAnalyzer {
    int CARDS_NUMBER = 5;

    IHand analyze(Player player);

    default IHand getHand(Player player) throws Exception {
        if (preCheck(player)) {
            return this.analyze(player);
        }
        return null;
    }


    static boolean preCheck(Player player) throws Exception {
        if (player != null && player.getCards() != null && player.getCards().size() == CARDS_NUMBER) {
            return true;
        } else {
            throw new Exception("Error");
        }
    }


    /**
     * Retourner une valeur boolean
     * Si les valeurs de cards sont consécutifs, retourner true.
     * Sinon, retourner false
     *
     * @param cards une liste de cards
     * @return boolean
     */
    static boolean isConsecutive(List<Card> cards) {
        List<Card> sortedCards = HandUtil.sortDesc(cards);
        for (int i = 0; i < sortedCards.size() - 1; i++) {
            if (sortedCards.get(i).getIntValue() - sortedCards.get(i + 1).getIntValue() != 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retourner une valeur boolean
     * Si toutes les cards sont de même suit, retourner true
     * Sinon, retourner false
     *
     * @param cards une liste de cards
     * @return boolean
     */
    static boolean isSameSuit(List<Card> cards) {
        if (cards != null && !cards.isEmpty()) {
            return cards.stream().map(c -> c.getSuit().getName()).distinct().count() == 1;
        } else {
            return false;
        }
    }

}
