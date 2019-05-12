package com.poker.hand;

import com.poker.Player;
import com.poker.enums.PokerHandTypeEnum;

public class StraightHand extends AbstractHand{
    private PokerHandTypeEnum type = PokerHandTypeEnum.STRAIGHT;

    @Override
    public PokerHandTypeEnum getType() {
        return type;
    }

    @Override
    public int compare(Player o1, Player o2) {
        return compareByHighestCardValue(o1,o2);
    }
}
