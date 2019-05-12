package com.poker.hand;

import com.poker.Card;
import com.poker.Player;
import com.poker.enums.PokerHandTypeEnum;

public class StraightFlushHand extends AbstractHand {
    private PokerHandTypeEnum type = PokerHandTypeEnum.STRAIGHT_FLUSH;

    @Override
    public PokerHandTypeEnum getType() {
        return type;
    }

    @Override
    public String getRankingMessage(Player p1, Player p2) {
        return getContent();
    }


    @Override
    public int compare(Player o1, Player o2) {
        return compareHighestCard(o1,o2);
    }


}
