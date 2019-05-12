package com.poker;

import com.poker.enums.SuitEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PokerGameIT{
    @Test
    public void BlackWinWithStraightFlush() throws Exception {
        Player p1,p2;
        List<Card> p1Cards = new ArrayList<>();
        p1Cards.add(new Card(SuitEnum.HEART,"7"));
        p1Cards.add(new Card(SuitEnum.HEART,"3"));
        p1Cards.add(new Card(SuitEnum.HEART,"4"));
        p1Cards.add(new Card(SuitEnum.HEART,"5"));
        p1Cards.add(new Card(SuitEnum.HEART,"6"));
        p1 = new Player("Black",p1Cards);


        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.SPADE,"2"));
        p2Cards.add(new Card(SuitEnum.SPADE,"3"));
        p2Cards.add(new Card(SuitEnum.SPADE,"4"));
        p2Cards.add(new Card(SuitEnum.SPADE,"5"));
        p2Cards.add(new Card(SuitEnum.SPADE,"6"));
        p2 = new Player("White",p2Cards);

        PokerGame game = new PokerGame(p1,p2);
        String result = game.printGameResult();
        Assert.assertEquals("Black win. - with straight flush: highest card 7",result);
    }

    @Test
    public void BlackWinWithFourKind() throws Exception {
        Player p1,p2;
        List<Card> p1Cards = new ArrayList<>();
        p1Cards.add(new Card(SuitEnum.HEART,"3"));
        p1Cards.add(new Card(SuitEnum.SPADE,"3"));
        p1Cards.add(new Card(SuitEnum.DIAMOND,"3"));
        p1Cards.add(new Card(SuitEnum.CLUB,"3"));
        p1Cards.add(new Card(SuitEnum.HEART,"6"));
        p1 = new Player("Black",p1Cards);


        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.HEART,"2"));
        p2Cards.add(new Card(SuitEnum.SPADE,"2"));
        p2Cards.add(new Card(SuitEnum.DIAMOND,"2"));
        p2Cards.add(new Card(SuitEnum.CLUB,"2"));
        p2Cards.add(new Card(SuitEnum.CLUB,"6"));
        p2 = new Player("White",p2Cards);

        PokerGame game = new PokerGame(p1,p2);
        String result = game.printGameResult();
        Assert.assertEquals("Black win. - with four of a kind: 4 cards of 3",result);
    }

    @Test
    public void BlackWinWithFullHouse() throws Exception {
        Player p1,p2;
        List<Card> p1Cards = new ArrayList<>();
        p1Cards.add(new Card(SuitEnum.HEART,"7"));
        p1Cards.add(new Card(SuitEnum.SPADE,"7"));
        p1Cards.add(new Card(SuitEnum.DIAMOND,"7"));
        p1Cards.add(new Card(SuitEnum.CLUB,"3"));
        p1Cards.add(new Card(SuitEnum.HEART,"3"));
        p1 = new Player("Black",p1Cards);


        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.HEART,"2"));
        p2Cards.add(new Card(SuitEnum.SPADE,"2"));
        p2Cards.add(new Card(SuitEnum.DIAMOND,"2"));
        p2Cards.add(new Card(SuitEnum.CLUB,"6"));
        p2Cards.add(new Card(SuitEnum.SPADE,"6"));
        p2 = new Player("White",p2Cards);

        PokerGame game = new PokerGame(p1,p2);
        String result = game.printGameResult();
        Assert.assertEquals("Black win. - with full house: 7 over 3",result);
    }

    @Test
    public void BlackWinWithFlush() throws Exception {
        Player p1,p2;
        List<Card> p1Cards = new ArrayList<>();
        p1Cards.add(new Card(SuitEnum.HEART,"7"));
        p1Cards.add(new Card(SuitEnum.HEART,"8"));
        p1Cards.add(new Card(SuitEnum.HEART,"T"));
        p1Cards.add(new Card(SuitEnum.HEART,"A"));
        p1Cards.add(new Card(SuitEnum.HEART,"Q"));
        p1 = new Player("Black",p1Cards);


        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.SPADE,"8"));
        p2Cards.add(new Card(SuitEnum.SPADE,"A"));
        p2Cards.add(new Card(SuitEnum.SPADE,"Q"));
        p2Cards.add(new Card(SuitEnum.SPADE,"9"));
        p2Cards.add(new Card(SuitEnum.SPADE,"6"));
        p2 = new Player("White",p2Cards);

        PokerGame game = new PokerGame(p1,p2);
        String result = game.printGameResult();
        Assert.assertEquals("Black win. - with flush: higher card T",result);
    }

    @Test
    public void BlackWinWithStraight() throws Exception {
        Player p1,p2;
        List<Card> p1Cards = new ArrayList<>();
        p1Cards.add(new Card(SuitEnum.HEART,"7"));
        p1Cards.add(new Card(SuitEnum.SPADE,"3"));
        p1Cards.add(new Card(SuitEnum.HEART,"4"));
        p1Cards.add(new Card(SuitEnum.HEART,"5"));
        p1Cards.add(new Card(SuitEnum.HEART,"6"));
        p1 = new Player("Black",p1Cards);


        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.SPADE,"2"));
        p2Cards.add(new Card(SuitEnum.SPADE,"3"));
        p2Cards.add(new Card(SuitEnum.SPADE,"4"));
        p2Cards.add(new Card(SuitEnum.DIAMOND,"5"));
        p2Cards.add(new Card(SuitEnum.SPADE,"6"));
        p2 = new Player("White",p2Cards);

        PokerGame game = new PokerGame(p1,p2);
        String result = game.printGameResult();
        Assert.assertEquals("Black win. - with straight: highest card 7",result);
    }

    @Test
    public void BlackWinWithThreeKind() throws Exception {
        Player p1,p2;
        List<Card> p1Cards = new ArrayList<>();
        p1Cards.add(new Card(SuitEnum.HEART,"7"));
        p1Cards.add(new Card(SuitEnum.SPADE,"7"));
        p1Cards.add(new Card(SuitEnum.DIAMOND,"7"));
        p1Cards.add(new Card(SuitEnum.HEART,"5"));
        p1Cards.add(new Card(SuitEnum.HEART,"6"));
        p1 = new Player("Black",p1Cards);


        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.SPADE,"4"));
        p2Cards.add(new Card(SuitEnum.DIAMOND,"4"));
        p2Cards.add(new Card(SuitEnum.CLUB,"4"));
        p2Cards.add(new Card(SuitEnum.DIAMOND,"5"));
        p2Cards.add(new Card(SuitEnum.SPADE,"6"));
        p2 = new Player("White",p2Cards);

        PokerGame game = new PokerGame(p1,p2);
        String result = game.printGameResult();
        Assert.assertEquals("Black win. - with three of a kind: three 7 cards",result);
    }
    @Test
    public void BlackWinWithHighCard() throws Exception {
        Player p1,p2;
        List<Card> p1Cards = new ArrayList<>();
        p1Cards.add(new Card(SuitEnum.HEART,"7"));
        p1Cards.add(new Card(SuitEnum.HEART,"8"));
        p1Cards.add(new Card(SuitEnum.DIAMOND,"T"));
        p1Cards.add(new Card(SuitEnum.HEART,"A"));
        p1Cards.add(new Card(SuitEnum.HEART,"Q"));
        p1 = new Player("Black",p1Cards);


        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.SPADE,"8"));
        p2Cards.add(new Card(SuitEnum.SPADE,"A"));
        p2Cards.add(new Card(SuitEnum.SPADE,"Q"));
        p2Cards.add(new Card(SuitEnum.SPADE,"9"));
        p2Cards.add(new Card(SuitEnum.CLUB,"6"));
        p2 = new Player("White",p2Cards);

        PokerGame game = new PokerGame(p1,p2);
        String result = game.printGameResult();
        Assert.assertEquals("Black win. - with high card: higher card T",result);
    }
}