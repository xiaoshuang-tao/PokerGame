package com.poker.hand;

import com.poker.Card;
import com.poker.enums.SuitEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HandUtilTest {

    @Test
    public void sortDescTest(){
        List<Card> cards = new ArrayList<>();
        Card card2 = new Card(SuitEnum.HEART, "2");
        Card card3 = new Card(SuitEnum.HEART, "3");
        Card card4 = new Card(SuitEnum.HEART, "4");
        Card card5 = new Card(SuitEnum.HEART, "5");
        Card card6 = new Card(SuitEnum.HEART, "6");
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);

        List<Card> result = HandUtil.sortDesc(cards);
        Assert.assertEquals(card6,result.get(0));
        Assert.assertEquals(card5,result.get(1));
        Assert.assertEquals(card4,result.get(2));
        Assert.assertEquals(card3,result.get(3));
        Assert.assertEquals(card2,result.get(4));
    }
}