package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.FourKindHand;
import com.poker.hand.HandUtil;
import com.poker.hand.IHand;

import java.util.LinkedHashMap;
import java.util.List;

public class FourKindHandAnalyer implements IHandAnalyzer {
    @Override
    public IHand analyze(Player player) {
        LinkedHashMap<String, List<Card>> result = HandUtil.groupByValueAndSortByQuantityAndValue(player.getCards());
        List<Card> firstCardList = HandUtil.findCardListInLinkedHashMapByOrder(result,0);
        if(firstCardList!=null && firstCardList.size()==4){
            IHand hand = new FourKindHand();
            hand.setContent("4 cards of "+firstCardList.get(0).getValue());
            return hand;
        }else{
            return null;
        }
    }
}
