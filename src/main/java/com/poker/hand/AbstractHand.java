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
    protected int sequenceCompare(Player o1, Player o2){
        List<Card> list1 = HandUtil.sortDesc(o1.getCards());
        List<Card> list2 = HandUtil.sortDesc(o2.getCards());
        int result = 0;
        for(int i =0;i<list1.size();i++){
            int value = Integer.compare(list1.get(i).getIntValue(),list2.get(i).getIntValue());
            if(result!=value){
                return value;
            }
        }
        return result;
    }
    protected String getRankingMessageBySequenceComparison(Player o1,Player o2){
        List<Card> list1 = HandUtil.sortDesc(o1.getCards());
        List<Card> list2 = HandUtil.sortDesc(o2.getCards());
        for(int i =0;i<list1.size();i++){
            int value = Integer.compare(list1.get(i).getIntValue(),list2.get(i).getIntValue());
            if(value==1){
                return "higher card "+list1.get(i).getValue();
            }
            if(value==-1){
                return "higher card "+list2.get(i).getValue();
            }
        }
        return null;
    }
}
