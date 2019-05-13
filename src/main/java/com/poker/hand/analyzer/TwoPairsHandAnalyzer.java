package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.HandUtil;
import com.poker.hand.IHand;
import com.poker.hand.TwoPairsHand;

import java.util.LinkedHashMap;
import java.util.List;

public class TwoPairsHandAnalyzer implements IHandAnalyzer{
    @Override
    public IHand analyze(Player player) {
        LinkedHashMap<String, List<Card>> result = HandUtil.groupByValueAndSortByQuantityAndValue(player.getCards());
        List<Card> firstCardList = HandUtil.findCardListInLinkedHashMapByOrder(result,0);
        List<Card> secondCardList = HandUtil.findCardListInLinkedHashMapByOrder(result,1);
        if(firstCardList!=null&&firstCardList.size()==2&&secondCardList!=null&&secondCardList.size()==2){
            IHand hand = new TwoPairsHand();
            hand.setContent(firstCardList.get(0).getValue()+" pair and "+secondCardList.get(0).getValue()+" pair");
            return hand;
        }else{
            return null;
        }
    }
}
