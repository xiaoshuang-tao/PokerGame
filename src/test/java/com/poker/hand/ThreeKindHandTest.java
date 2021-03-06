package com.poker.hand;

import com.poker.Card;
import com.poker.Player;
import com.poker.SuitEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ThreeKindHandTest {
    private IHand hand = new ThreeKindHand();
    @Test
    public void getTypeTest(){
        assertEquals(PokerHandTypeEnum.THREE_KIND,hand.getType());
    }
    @Test
    public void compareReturnOne() throws Exception{
        List<Card> p1Cards = new ArrayList<>();
        p1Cards.add(new Card(SuitEnum.HEART,"7"));
        p1Cards.add(new Card(SuitEnum.SPADE,"7"));
        p1Cards.add(new Card(SuitEnum.DIAMOND,"7"));
        p1Cards.add(new Card(SuitEnum.CLUB,"8"));
        p1Cards.add(new Card(SuitEnum.HEART,"6"));
        Player p1 = new Player("Black",p1Cards);


        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.HEART,"5"));
        p2Cards.add(new Card(SuitEnum.SPADE,"5"));
        p2Cards.add(new Card(SuitEnum.DIAMOND,"5"));
        p2Cards.add(new Card(SuitEnum.CLUB,"3"));
        p2Cards.add(new Card(SuitEnum.SPADE,"2"));
        Player p2 = new Player("White",p2Cards);
        assertEquals(1,hand.compare(p1,p2));
    }
    @Test
    public void compareReturnMinusOne() throws Exception {
        List<Card> p1Cards = new ArrayList<>();
        p1Cards.add(new Card(SuitEnum.HEART,"Q"));
        p1Cards.add(new Card(SuitEnum.SPADE,"Q"));
        p1Cards.add(new Card(SuitEnum.DIAMOND,"Q"));
        p1Cards.add(new Card(SuitEnum.CLUB,"T"));
        p1Cards.add(new Card(SuitEnum.HEART,"6"));
        Player p1 = new Player("Black",p1Cards);


        List<Card> p2Cards = new ArrayList<>();
        p2Cards.add(new Card(SuitEnum.HEART,"K"));
        p2Cards.add(new Card(SuitEnum.SPADE,"K"));
        p2Cards.add(new Card(SuitEnum.DIAMOND,"K"));
        p2Cards.add(new Card(SuitEnum.CLUB,"2"));
        p2Cards.add(new Card(SuitEnum.SPADE,"4"));
        Player p2 = new Player("White",p2Cards);
        assertEquals(-1,hand.compare(p1,p2));
    }
}