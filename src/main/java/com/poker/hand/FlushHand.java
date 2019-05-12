package com.poker.hand;

import com.poker.Card;
import com.poker.Player;
import com.poker.enums.PokerHandTypeEnum;

import java.util.List;

public class FlushHand extends AbstractHand{
    private PokerHandTypeEnum type = PokerHandTypeEnum.FLUSH;
    @Override
    public PokerHandTypeEnum getType() {
        return type;
    }

    @Override
    public String getRankingMessage(Player o1, Player o2) {
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

    @Override
    public int compare(Player o1, Player o2) {
        return sequenceCompare(o1,o2);
    }

    private int sequenceCompare(Player o1, Player o2){
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
}
