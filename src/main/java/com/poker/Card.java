package com.poker;


public class Card {
    private SuitEnum suit;
    private String value;

    public Card(SuitEnum suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public SuitEnum getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                value.equals(card.value);
    }


    public int getIntValue() throws IllegalArgumentException {
        switch (value) {
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                return Integer.parseInt(value);
            case "T":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                throw new IllegalArgumentException("Illegal card value: \""+value+"\"");
        }
    }
}
