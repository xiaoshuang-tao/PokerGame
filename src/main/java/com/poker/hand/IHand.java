package com.poker.hand;
import com.poker.Player;
import com.poker.enums.PokerHandTypeEnum;

import java.util.Comparator;

public interface IHand extends Comparator<Player> {
    PokerHandTypeEnum getType();
    String getContent();
    void setContent(String content);
    String getRankingMessage(Player p1,Player p2);

}
