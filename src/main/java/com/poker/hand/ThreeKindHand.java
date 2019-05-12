package com.poker.hand;

import com.poker.Player;
import com.poker.enums.PokerHandTypeEnum;

public class ThreeKindHand extends AbstractHand{
    private PokerHandTypeEnum type = PokerHandTypeEnum.THREE_KIND;
    @Override
    public PokerHandTypeEnum getType() {
        return type;
    }

    @Override
    public int compare(Player o1, Player o2) {
        return compareByMostCardValue(o1,o2);
    }
}
