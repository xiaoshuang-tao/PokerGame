package com.poker;

import com.poker.hand.HandUtil;
import com.poker.hand.IHand;

import java.util.*;


public class Player implements Comparable<Player>{
    private String name;
    private List<Card> cards;
    private IHand hand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public IHand getHand() {
        return hand;
    }

    public Player(String name,List<Card> cards) throws Exception {
        if (cards != null && cards.size() == 5) {
            this.name = name;
            this.cards = cards;
            this.hand = HandUtil.getHand(this);
        }else {
            throw new Exception("A player should have five cards.");
        }
    }

    @Override
    public int compareTo(Player o) {
        if(this.getHand().getType().getRank()>o.getHand().getType().getRank()){
            return 1;
        }else if(this.getHand().getType().getRank()<o.getHand().getType().getRank()){
            return -1;
        }else{
            return this.getHand().compare(this,o);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
