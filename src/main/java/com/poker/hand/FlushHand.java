package com.poker.hand;

import com.poker.Player;

public class FlushHand extends AbstractHand{
    private PokerHandTypeEnum type = PokerHandTypeEnum.FLUSH;
    @Override
    public PokerHandTypeEnum getType() {
        return type;
    }

    @Override
    public String getRankingMessage(Player o1, Player o2) {
        return getRankingMessageBySequenceComparison(o1,o2);
    }

    @Override
    public int compare(Player o1, Player o2) {
        return sequenceCompare(o1,o2);
    }


}
