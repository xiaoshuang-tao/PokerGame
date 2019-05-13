package com.poker.hand;

import com.poker.Card;
import com.poker.Player;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHand implements IHand {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Card findHighest(Player p) {
        return HandUtil.sortDesc(p.getCards()).get(0);
    }

    protected int compareByHighestCardValue(Player o1,Player o2){
        return Integer.compare(findHighest(o1).getIntValue(), findHighest(o2).getIntValue());
    }
    @Override
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
    protected String getRankingMessageByMapComparison(Player o1,Player o2){
        Iterator<Map.Entry<String,List<Card>>> it1 = getSortedMapIterator(o1);
        Iterator<Map.Entry<String,List<Card>>> it2 = getSortedMapIterator(o2);
        Map.Entry<String,List<Card>> entry1,entry2;
        while(it1.hasNext()&&it2.hasNext()){
            entry1 = it1.next();
            entry2 = it2.next();
            if(entry1.getValue().get(0).getIntValue()>entry2.getValue().get(0).getIntValue()){
                return entry1.getValue().size()==2
                        ? " pair of "+entry1.getValue().get(0).getValue()
                        : " higher card "+entry1.getValue().get(0).getValue();
            }else if(entry1.getValue().get(0).getIntValue()<entry2.getValue().get(0).getIntValue()){
                return entry2.getValue().size()==2
                        ? " pair of "+entry2.getValue().get(0).getValue()
                        : " higher card "+entry2.getValue().get(0).getValue();
            }
        }
        return "";
    }
    protected int compareBySortedMap(Player o1,Player o2){
        Iterator<Map.Entry<String,List<Card>>> it1 = getSortedMapIterator(o1);
        Iterator<Map.Entry<String,List<Card>>> it2 = getSortedMapIterator(o2);
        Map.Entry<String,List<Card>> entry1,entry2;
        while(it1.hasNext()&&it2.hasNext()){
            entry1 = it1.next();
            entry2 = it2.next();
            if(entry1.getValue().get(0).getIntValue()>entry2.getValue().get(0).getIntValue()){
                return 1;
            }else if(entry1.getValue().get(0).getIntValue()<entry2.getValue().get(0).getIntValue()){
                return -1;
            }
        }
        return 0;
    }
    private Iterator<Map.Entry<String,List<Card>>> getSortedMapIterator(Player p){
        LinkedHashMap<String,List<Card>> sortedMap = HandUtil.groupByValueAndSortByQuantityAndValue(p.getCards());
        return sortedMap.entrySet().iterator();
    }
}
