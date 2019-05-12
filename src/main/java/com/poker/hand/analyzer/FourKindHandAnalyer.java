package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.FourKindHand;
import com.poker.hand.HandUtil;
import com.poker.hand.IHand;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FourKindHandAnalyer implements IHandAnalyzer {
    @Override
    public IHand analyze(Player player) {
        LinkedHashMap<String, List<Card>> result = HandUtil.groupByValueAndSortByQuantityAndValue(player.getCards());
        Iterator<Map.Entry<String,List<Card>>> it = result.entrySet().iterator();
        Map.Entry<String,List<Card>> firstEntry = it.next();
        if(firstEntry.getValue().size()==4){
            IHand hand = new FourKindHand();
            hand.setContent("4 cards of "+firstEntry.getValue().get(0).getValue());
            return hand;
        }else{
            return null;
        }
    }
}
