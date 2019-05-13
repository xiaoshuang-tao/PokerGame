package com.poker;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CardTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetIntValueOfCard6(){
        Card c = new Card (SuitEnum.HEART,"6");
        assertEquals(6, c.getIntValue());
    }

    @Test
    public void testGetIntValueOfCardT(){
        Card c = new Card (SuitEnum.HEART,"T");
        assertEquals(10, c.getIntValue());
    }

    @Test
    public void testGetIntValueOfCardThrowException(){
        thrown.expect(IllegalArgumentException.class);
        Card c = new Card (SuitEnum.HEART,"1");
        c.getIntValue();
    }

}