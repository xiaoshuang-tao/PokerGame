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
        p1Cards.add(new Card(SuitEnum.HEART,"2"));
        p1Cards.add(new Card(SuitEnum.DIAMOND,"3"));
        p1Cards.add(new Card(SuitEnum.SPADE,"5"));
        p1Cards.add(new Card(SuitEnum.CLUB,"9"));
        p1Cards.add(new Card(SuitEnum.DIAMOND,"K"));
        p1 = new Player("Black",p1Cards);


        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.CLUB,"2"));
        p2Cards.add(new Card(SuitEnum.HEART,"3"));
        p2Cards.add(new Card(SuitEnum.SPADE,"4"));
        p2Cards.add(new Card(SuitEnum.CLUB,"8"));
        p2Cards.add(new Card(SuitEnum.HEART,"K"));
        p2 = new Player("White",p2Cards);

        PokerGame game = new PokerGame(p1,p2);
        String result = game.printGameResult();
        Assert.assertEquals("Black wins. - with high card :9",result);
    }
}