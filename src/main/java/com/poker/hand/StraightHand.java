package com.poker.hand;

import com.poker.Player;

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
