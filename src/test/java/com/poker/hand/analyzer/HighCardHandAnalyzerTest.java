package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.SuitEnum;
import com.poker.hand.HighCardHand;
import com.poker.hand.IHand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HighCardHandAnalyzerTest {
    private IHandAnalyzer highCardHandAnalyzer = new HighCardHandAnalyzer();
    @Test
    public void getHandTest() throws Exception {
        List<Card> cards = new ArrayList<>();
        Card card2 = new Card(SuitEnum.HEART, "2");
        Card card3 = new Card(SuitEnum.HEART, "8");
        Card card4 = new Card(SuitEnum.SPADE, "4");
        Card card5 = new Card(SuitEnum.HEART, "K");
        Card card6 = new Card(SuitEnum.HEART, "T");
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        Player player = new Player("black", cards);
        IHand hand = highCardHandAnalyzer.getHand(player);
        assertTrue(hand instanceof HighCardHand);
    }

    @Test
    public void analyzeReturnHighCardHand() throws Exception {
        List<Card> cards = new ArrayList<>();
        Card card2 = new Card(SuitEnum.HEART, "2");
        Card card3 = new Card(SuitEnum.SPADE, "8");
        Card card4 = new Card(SuitEnum.HEART, "4");
        Card card5 = new Card(SuitEnum.DIAMOND, "K");
        Card card6 = new Card(SuitEnum.HEART, "T");
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        Player player = new Player("black", cards);
        IHand hand = highCardHandAnalyzer.analyze(player);
        assertTrue(hand instanceof HighCardHand);
    }

    @Test
    public void analyzeReturnNotNull() throws Exception {
        List<Card> cards = new ArrayList<>();
        Card card2 = new Card(SuitEnum.HEART, "2");
        Card card3 = new Card(SuitEnum.HEART, "3");
        Card card4 = new Card(SuitEnum.HEART, "4");
        Card card5 = new Card(SuitEnum.SPADE, "5");
        Card card6 = new Card(SuitEnum.HEART, "8");
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        Player player = new Player("black", cards);
        IHand hand = highCardHandAnalyzer.analyze(player);
        assertNotNull(hand);
    }
}