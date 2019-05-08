package com.poker;

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
    public void play1Wins() throws Exception {
        when(p1.compareTo(p2)).thenReturn(1);

        String result = game.printGameResult();
        Assert.assertFalse("Tie.".equals(result));
    }

    @Test
    public void tie() throws Exception {
        when(p1.compareTo(p2)).thenReturn(0);

        String result = game.printGameResult();
        Assert.assertTrue("Tie.".equals(result));
    }
}
