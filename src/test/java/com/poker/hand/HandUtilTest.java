package com.poker.hand;

import com.poker.Card;
import com.poker.SuitEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void groupByValueAndSortByQuantityAndValueTest(){
        List<Card> cards = new ArrayList<>();
        Card card2 = new Card(SuitEnum.SPADE, "2");
        Card card3 = new Card(SuitEnum.HEART, "2");
        Card card4 = new Card(SuitEnum.HEART, "3");
        Card card5 = new Card(SuitEnum.SPADE, "4");
        Card card6 = new Card(SuitEnum.HEART, "4");
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        LinkedHashMap<String,List<Card>> result = HandUtil.groupByValueAndSortByQuantityAndValue(cards);
        assertEquals(3, result.size());
        Iterator<Map.Entry<String,List<Card>>> it = result.entrySet().iterator();
        Map.Entry<String,List<Card>> firstEntry = it.next();
        assertEquals(2,firstEntry.getValue().size());
        assertEquals("4",firstEntry.getKey());
        Map.Entry<String,List<Card>> secondEntry = it.next();
        assertEquals(2,secondEntry.getValue().size());
        assertEquals("2",secondEntry.getKey());
        Map.Entry<String,List<Card>> thirdEntry = it.next();
        assertEquals(1,thirdEntry.getValue().size());
        assertEquals("3",thirdEntry.getKey());
    }

    @Test
    public void findCardListInLinkedHashMapByOrderReturnFirstEntryValue(){
        LinkedHashMap<String,List<Card>> map = new LinkedHashMap<>();
        List<Card> list1 = new ArrayList<>();
        List<Card> list2 = new ArrayList<>();
        Card card2 = new Card(SuitEnum.SPADE, "2");
        Card card3 = new Card(SuitEnum.HEART, "2");
        Card card4 = new Card(SuitEnum.CLUB, "2");
        Card card5 = new Card(SuitEnum.SPADE, "4");
        Card card6 = new Card(SuitEnum.HEART, "4");
        list1.add(card2);
        list1.add(card3);
        list1.add(card4);
        list2.add(card5);
        list2.add(card6);
        map.put("2",list1);
        map.put("4",list2);
        List<Card> result = HandUtil.findCardListInLinkedHashMapByOrder(map,0);
        assertEquals(3,result.size());
        assertEquals("2",result.get(0).getValue());
    }

}