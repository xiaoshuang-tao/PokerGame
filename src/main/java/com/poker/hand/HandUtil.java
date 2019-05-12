package com.poker.hand;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.analyzer.*;

import java.util.*;
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
        handAnalyzers.add(new FourKindHandAnalyer());
        handAnalyzers.add(new FullHouseHandAnalyzer());
        handAnalyzers.add(new FlushHandAnalyzer());
        handAnalyzers.add(new StraightHandAnalyzer());
        handAnalyzers.add(new ThreeKindHandAnalyzer());
        handAnalyzers.add(new HighCardHandAnalyzer());
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

    /**
     * Retourner une LinkedHashMap
     * Grouper les cartes par leurs valeurs et lister par nombre de cartes d'abord et ensuite leurs valeurs dans l'ordre décroissant
     *
     * @param cards une liste de cards
     * @return LinkedHashMap<String, List < Card>>
     */
    public static LinkedHashMap<String, List<Card>> groupByValueAndSortByQuantityAndValue(List<Card> cards) {
        Map<String, List<Card>> map = cards.stream().collect(Collectors.groupingBy(Card::getValue));
        return map.entrySet().stream().sorted(HandUtil::compareBySizeThenValue).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private static int compareBySizeThenValue(Map.Entry<String, List<Card>> e1, Map.Entry<String, List<Card>> e2) {
        if (e1.getValue().size() == e2.getValue().size()) {
            return e2.getValue().get(0).getIntValue() - e1.getValue().get(0).getIntValue();
        } else {
            return e2.getValue().size() - e1.getValue().size();
        }
    }

    public static List<Card> findCardListInLinkedHashMapByOrder(LinkedHashMap<String, List<Card>> map,int order){
        int i = -1;
        Iterator<Map.Entry<String,List<Card>>> it = map.entrySet().iterator();
        Map.Entry<String,List<Card>> entry = null;
        while(it.hasNext()&&i<order){
            entry = it.next();
            i++;
        }
        return entry!=null?entry.getValue():null;
    }

}
