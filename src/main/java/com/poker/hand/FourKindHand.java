package com.poker.hand;

import com.poker.Card;
import com.poker.Player;
import com.poker.enums.PokerHandTypeEnum;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FourKindHand extends AbstractHand{
    private PokerHandTypeEnum type = PokerHandTypeEnum.FOUR_KIND;
    @Override
    public PokerHandTypeEnum getType() {
        return type;
    }

    @Override
    public int compare(Player o1, Player o2) {
        int player1FourCardValue = findFourSameCardValue(o1);
        int player2FourCardValue = findFourSameCardValue(o2);
        return Integer.compare(player1FourCardValue,player2FourCardValue);
    }

    private int findFourSameCardValue(Player p){
        LinkedHashMap<String, List<Card>> result = HandUtil.groupByValueAndSortByQuantityAndValue(p.getCards());
        List<Card> firstCardList = HandUtil.findCardListInLinkedHashMapByOrder(result,0);
        return firstCardList.get(0).getIntValue();
    }
}
