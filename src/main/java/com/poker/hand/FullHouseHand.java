package com.poker.hand;

import com.poker.Card;
import com.poker.Player;
import com.poker.enums.PokerHandTypeEnum;

import java.util.LinkedHashMap;
import java.util.List;

public class FullHouseHand extends AbstractHand {
    private PokerHandTypeEnum type = PokerHandTypeEnum.FULL_HOUSE;

    @Override
    public PokerHandTypeEnum getType() {
        return type;
    }

    @Override
    public int compare(Player o1, Player o2) {
        return compareByMostCardValue(o1,o2);
    }
}
