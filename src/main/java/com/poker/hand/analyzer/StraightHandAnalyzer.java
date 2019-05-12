package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.HandUtil;
import com.poker.hand.IHand;
import com.poker.hand.StraightHand;

import java.util.List;

public class StraightHandAnalyzer implements IHandAnalyzer{
    @Override
    public IHand analyze(Player player) {
        List<Card> sortedCards = HandUtil.sortDesc(player.getCards());
        if(IHandAnalyzer.isConsecutive(sortedCards)){
            IHand result = new StraightHand();
            result.setContent("highest card "+sortedCards.get(0).getValue());
            return result;
        }
        return null;
    }
}
