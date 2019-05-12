package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.hand.HandUtil;
import com.poker.hand.HighCardHand;
import com.poker.hand.IHand;

import java.util.List;

public class HighCardHandAnalyzer implements IHandAnalyzer{
    @Override
    public IHand analyze(Player player) {
        List<Card> sortedCards = HandUtil.sortDesc(player.getCards());
        IHand hand = new HighCardHand();
        hand.setContent("highest card "+sortedCards.get(0).getValue());
        return hand;
    }
}
