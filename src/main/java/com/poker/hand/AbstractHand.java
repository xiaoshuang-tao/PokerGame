package com.poker.hand;

public abstract class AbstractHand implements IHand {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
