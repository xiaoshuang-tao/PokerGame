package com.poker.hand;

import com.poker.Player;
import com.poker.enums.PokerHandTypeEnum;

public class HighCardHand extends AbstractHand {
    private PokerHandTypeEnum type = PokerHandTypeEnum.HIGH_CARD;
    @Override
    public PokerHandTypeEnum getType() {
        return type;
    }

    @Override
    public int compare(Player o1, Player o2) {
        return 0;
    }
}
