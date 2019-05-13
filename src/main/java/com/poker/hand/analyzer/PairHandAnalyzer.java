package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.HandUtil;
import com.poker.hand.IHand;
import com.poker.hand.PairHand;

import java.util.LinkedHashMap;
import java.util.List;

public class PairHandAnalyzer implements IHandAnalyzer{

    @Override
    public IHand analyze(Player player) {
        LinkedHashMap<String, List<Card>> result = HandUtil.groupByValueAndSortByQuantityAndValue(player.getCards());
        List<Card> firstCardList = HandUtil.findCardListInLinkedHashMapByOrder(result,0);
        if(firstCardList!=null&&firstCardList.size()==2&&result!=null&&result.size()==4){
            IHand hand = new PairHand();
            hand.setContent(firstCardList.get(0).getValue()+" pair");
            return hand;
        }else{
            return null;
        }
    }
}
