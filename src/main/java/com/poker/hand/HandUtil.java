package com.poker.hand;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.analyzer.IHandAnalyzer;
import com.poker.hand.analyzer.StraightFlushHandAnalyzer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HandUtil {
    private static final List<IHandAnalyzer> handAnalyzers = new ArrayList<>();

    /**
     * Retourner une liste de cards dans l'ordre décroissant par leurs valeurs
     *
     * @param cards une liste de cards
     * @return List<Card>
     */
    public static List<Card> sortDesc(List<Card> cards) {
        return cards.stream().sorted(Comparator.comparingInt(Card::getIntValue).reversed()).collect(Collectors.toList());
    }

    public static List<IHandAnalyzer> getHandAnalyzers(){
        handAnalyzers.add(new StraightFlushHandAnalyzer());
        return handAnalyzers;
    }

    public static IHand getHand(Player player) throws Exception {
        for(IHandAnalyzer handAnalyzer : getHandAnalyzers()){
            IHand hand = handAnalyzer.getHand(player);
            if(hand!=null){
                return hand;
            }
        }
        return null;
    }

    public static String getHigherCardMessage(Player winner,Player player1, Player player2) {
        return winner.getHand().getContent();
    }
}
