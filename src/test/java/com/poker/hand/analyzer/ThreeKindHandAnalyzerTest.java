package com.poker.hand.analyzer;

import com.poker.Card;
import com.poker.Player;
import com.poker.enums.SuitEnum;
import com.poker.hand.FullHouseHand;
import com.poker.hand.IHand;
import com.poker.hand.ThreeKindHand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ThreeKindHandAnalyzerTest {
    private IHandAnalyzer threeKindHandAnalyzer = new ThreeKindHandAnalyzer();
    @Test
    public void getHandTest() throws Exception {
        List<Card> cards = new ArrayList<>();
        Card card2 = new Card(SuitEnum.HEART, "2");
        Card card3 = new Card(SuitEnum.DIAMOND, "2");
        Card card4 = new Card(SuitEnum.CLUB, "2");
        Card card5 = new Card(SuitEnum.SPADE, "8");
        Card card6 = new Card(SuitEnum.HEART, "6");
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        Player player = new Player("black", cards);
        IHand hand = threeKindHandAnalyzer.getHand(player);
        assertTrue(hand instanceof ThreeKindHand);
    }

    @Test
    public void analyzeReturnThreeKindHand() throws Exception {
        List<Card> cards = new ArrayList<>();
        Card card2 = new Card(SuitEnum.HEART, "2");
        Card card3 = new Card(SuitEnum.DIAMOND, "2");
        Card card4 = new Card(SuitEnum.CLUB, "2");
        Card card5 = new Card(SuitEnum.SPADE, "7");
        Card card6 = new Card(SuitEnum.HEART, "6");
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        Player player = new Player("black", cards);
        IHand hand = threeKindHandAnalyzer.analyze(player);
        assertTrue(hand instanceof ThreeKindHand);
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
        IHand hand = threeKindHandAnalyzer.analyze(player);
        assertNull(hand);
    }
}