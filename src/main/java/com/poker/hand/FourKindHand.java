package com.poker.hand;

import com.poker.Player;


public class FourKindHand extends AbstractHand{
    private PokerHandTypeEnum type = PokerHandTypeEnum.FOUR_KIND;
    @Override
    public PokerHandTypeEnum getType() {
        return type;
    }

    @Override
    public int compare(Player o1, Player o2) {
        return compareByMostCardValue(o1,o2);
    }
}
