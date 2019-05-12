package com.poker;

import com.poker.enums.SuitEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PokerGameIT{
    @Test
    public void BlackWinWith() throws Exception {
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
}