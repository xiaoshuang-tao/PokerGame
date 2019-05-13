package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.SuitEnum;
import com.poker.hand.FourKindHand;
import com.poker.hand.IHand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FourKindHandAnalyerTest {
    private IHandAnalyzer fourKindHandAnalyer = new FourKindHandAnalyer();
    @Test
    public void getHandTest() throws Exception {
        List<Card> cards = new ArrayList<>();
        Card card2 = new Card(SuitEnum.HEART, "2");
        Card card3 = new Card(SuitEnum.DIAMOND, "2");
        Card card4 = new Card(SuitEnum.CLUB, "2");
        Card card5 = new Card(SuitEnum.SPADE, "2");
        Card card6 = new Card(SuitEnum.HEART, "6");
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        Player player = new Player("black", cards);
        IHand hand = fourKindHandAnalyer.getHand(player);
        assertTrue(hand instanceof FourKindHand);
    }

    @Test
    public void analyzeReturnFourKindHand() throws Exception {
        List<Card> cards = new ArrayList<>();
        Card card2 = new Card(SuitEnum.HEART, "2");
        Card card3 = new Card(SuitEnum.DIAMOND, "2");
        Card card4 = new Card(SuitEnum.CLUB, "2");
        Card card5 = new Card(SuitEnum.SPADE, "2");
        Card card6 = new Card(SuitEnum.HEART, "6");
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        Player player = new Player("black", cards);
        IHand hand = fourKindHandAnalyer.analyze(player);
        assertTrue(hand instanceof FourKindHand);
    }

    @Test
    public void analyzeReturnNull() throws Exception {
        List<Card> cards = new ArrayList<>();
        Card card2 = new Card(SuitEnum.HEART, "2");
        Card card3 = new Card(SuitEnum.HEART, "3");
        Card card4 = new Card(SuitEnum.HEART, "4");
        Card card5 = new Card(SuitEnum.HEART, "5");
        Card card6 = new Card(SuitEnum.HEART, "8");
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        Player player = new Player("black", cards);
        IHand hand = fourKindHandAnalyer.analyze(player);
        assertNull(hand);
    }

}