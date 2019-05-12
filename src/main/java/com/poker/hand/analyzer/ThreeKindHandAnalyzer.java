package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.HandUtil;
import com.poker.hand.IHand;
import com.poker.hand.ThreeKindHand;

import java.util.LinkedHashMap;
import java.util.List;

public class ThreeKindHandAnalyzer implements IHandAnalyzer{
    @Override
    public IHand analyze(Player player) {
        LinkedHashMap<String, List<Card>> result = HandUtil.groupByValueAndSortByQuantityAndValue(player.getCards());
        List<Card> firstCardList = HandUtil.findCardListInLinkedHashMapByOrder(result,0);
        List<Card> secondCardList = HandUtil.findCardListInLinkedHashMapByOrder(result,1);
        if(firstCardList!=null&&firstCardList.size()==3&&secondCardList!=null&&secondCardList.size()==1){
            IHand hand = new ThreeKindHand();
            hand.setContent("three "+firstCardList.get(0).getValue()+" cards");
            return hand;
        }else{
            return null;
        }
    }
}
