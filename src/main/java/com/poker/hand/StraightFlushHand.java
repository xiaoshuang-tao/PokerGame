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
    public int compare(Player o1, Player o2) {
        return compareByHighestCardValue(o1,o2);
    }


}
