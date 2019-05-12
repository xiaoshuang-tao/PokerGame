package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.FlushHand;
import com.poker.hand.HandUtil;
import com.poker.hand.IHand;


import java.util.List;

public class FlushHandAnalyzer implements IHandAnalyzer{
    @Override
    public IHand analyze(Player player) {
        List<Card> sortedCards = HandUtil.sortDesc(player.getCards());
        if(IHandAnalyzer.isSameSuit(sortedCards)){
            IHand result = new FlushHand();
            result.setContent("highest card "+sortedCards.get(0).getValue());
            return result;
        }
        return null;
    }
}
