package com.poker.hand;

import com.poker.Card;
import com.poker.Player;

import java.util.LinkedHashMap;
import java.util.List;

public abstract class AbstractHand implements IHand {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    protected Card findHighest(Player p) {
        return HandUtil.sortDesc(p.getCards()).get(0);
    }

    protected int compareByHighestCardValue(Player o1,Player o2){
        return Integer.compare(findHighest(o1).getIntValue(), findHighest(o2).getIntValue());
    }
    public String getRankingMessage(Player p1, Player p2) {
        return getContent();
    }
    protected int compareByMostCardValue(Player o1, Player o2){
        return Integer.compare(findMostCard(o1).getIntValue(), findMostCard(o2).getIntValue());
    }
    private Card findMostCard(Player p){
        LinkedHashMap<String, List<Card>> result = HandUtil.groupByValueAndSortByQuantityAndValue(p.getCards());
        List<Card> firstCardList = HandUtil.findCardListInLinkedHashMapByOrder(result,0);
        return firstCardList.get(0);
    }
}
