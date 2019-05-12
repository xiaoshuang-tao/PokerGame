package com.poker.hand;

import com.poker.Card;
import com.poker.Player;

public abstract class AbstractHand implements IHand {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    protected Card findHighest(Player p) {
        return HandUtil.sortDesc(p.getCards()).get(0);
    }

    protected int compareHighestCard(Player o1,Player o2){
        return Integer.compare(findHighest(o1).getIntValue(), findHighest(o2).getIntValue());
    }
}
