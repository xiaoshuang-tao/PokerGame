package com.poker.hand;

import com.poker.Player;

public class TwoPairsHand extends AbstractHand{
    private PokerHandTypeEnum type = PokerHandTypeEnum.TWO_PAIRS;

    @Override
    public PokerHandTypeEnum getType() {
        return type;
    }
    @Override
    public String getRankingMessage(Player p1, Player p2){
        return getRankingMessageByMapComparison(p1,p2);
    }


    @Override
    public int compare(Player o1, Player o2) {
        return compareBySortedMap(o1,o2);
    }
}
