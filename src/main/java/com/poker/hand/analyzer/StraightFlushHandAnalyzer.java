package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.HandUtil;
import com.poker.hand.IHand;
import com.poker.hand.StraightFlushHand;

import java.util.List;

public class StraightFlushHandAnalyzer implements IHandAnalyzer{
    @Override
    public IHand analyze(Player player) {
        List<Card> sortedCards = HandUtil.sortDesc(player.getCards());
        if(IHandAnalyzer.isConsecutive(sortedCards)&& IHandAnalyzer.isSameSuit(sortedCards)){
            StraightFlushHand result = new StraightFlushHand();
            result.setContent("highest card "+sortedCards.get(0).getValue());
            return result;
        }
        return null;
    }
}
