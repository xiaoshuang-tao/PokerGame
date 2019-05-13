package com.poker;

import com.poker.hand.StraightFlushHand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTest {
    private Player p1;
    private Player p2;

    @Before
    public void setUp() throws Exception {
        List<Card> p1Cards = new ArrayList<>();
        p1Cards.add(new Card(SuitEnum.HEART,"7"));
        p1Cards.add(new Card(SuitEnum.HEART,"3"));
        p1Cards.add(new Card(SuitEnum.HEART,"4"));
        p1Cards.add(new Card(SuitEnum.HEART,"5"));
        p1Cards.add(new Card(SuitEnum.HEART,"6"));
        p1 = new Player("Black",p1Cards);
    }

    @Test
    public void showHandReturnStraightFlushHand() throws Exception {
        Assert.assertTrue(p1.getHand() instanceof StraightFlushHand);
    }
    @Test
    public void compareReturnOne() throws Exception {
        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.SPADE,"2"));
        p2Cards.add(new Card(SuitEnum.SPADE,"3"));
        p2Cards.add(new Card(SuitEnum.SPADE,"4"));
        p2Cards.add(new Card(SuitEnum.SPADE,"5"));
        p2Cards.add(new Card(SuitEnum.SPADE,"6"));
        p2 = new Player("White",p2Cards);
        Assert.assertEquals(1,p1.compareTo(p2));
    }

    @Test
    public void compareReturnMinusOne() throws Exception {
        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.SPADE,"7"));
        p2Cards.add(new Card(SuitEnum.SPADE,"8"));
        p2Cards.add(new Card(SuitEnum.SPADE,"4"));
        p2Cards.add(new Card(SuitEnum.SPADE,"5"));
        p2Cards.add(new Card(SuitEnum.SPADE,"6"));
        p2 = new Player("White",p2Cards);
        Assert.assertEquals(-1,p1.compareTo(p2));
    }

    @Test
    public void compareReturnZero() throws Exception {
        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.SPADE,"7"));
        p2Cards.add(new Card(SuitEnum.SPADE,"3"));
        p2Cards.add(new Card(SuitEnum.SPADE,"4"));
        p2Cards.add(new Card(SuitEnum.SPADE,"5"));
        p2Cards.add(new Card(SuitEnum.SPADE,"6"));
        p2 = new Player("White",p2Cards);
        Assert.assertEquals(0,p1.compareTo(p2));
    }


}