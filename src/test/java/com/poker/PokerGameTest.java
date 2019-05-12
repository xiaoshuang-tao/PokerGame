package com.poker;

import com.poker.hand.HighCardHand;
import com.poker.hand.StraightFlushHand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PokerGameTest {
    private Player p1;
    private Player p2;
    private PokerGame game;

    @Before
    public void setUp() throws Exception {
        p1 = mock(Player.class);
        p2 = mock(Player.class);
        game = new PokerGame(p1, p2);
    }

    @Test
    public void printGameResultReturnPlayerOneWinMessage() throws Exception {
        when(p1.getHand()).thenReturn(new StraightFlushHand());
        when(p2.getHand()).thenReturn(new HighCardHand());
        when(p1.getName()).thenReturn("player1");
        String result = game.printGameResult();
        Assert.assertTrue(result.contains("player1"));
    }

    @Test
    public void printGameResultReturnPlayerTwoWinMessage() throws Exception {
        when(p1.getHand()).thenReturn(new HighCardHand());
        when(p2.getHand()).thenReturn(new StraightFlushHand());
        when(p2.getName()).thenReturn("player2");
        String result = game.printGameResult();
        Assert.assertTrue(result.contains("player2"));
    }

    @Test
    public void printGameResultForSameHandTypeReturnPlayerOneWinMessage() throws Exception {
        when(p1.getHand()).thenReturn(new StraightFlushHand());
        when(p2.getHand()).thenReturn(new StraightFlushHand());
        when(p1.compareTo(p2)).thenReturn(-1);
        when(p2.getName()).thenReturn("player2");
        String result = game.printGameResult();
        Assert.assertTrue(result.contains("player2"));
    }

    @Test
    public void printGameResultForSameHandTypeReturnTieMessage() throws Exception {
        when(p1.compareTo(p2)).thenReturn(0);
        String result = game.printGameResult();
        Assert.assertTrue(result.contains("Tie"));
    }

}
