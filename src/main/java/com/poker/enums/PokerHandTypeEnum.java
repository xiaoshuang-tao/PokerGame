package com.poker.enums;

public enum PokerHandTypeEnum {
	STRAIGHT_FLUSH(9,"straight flush"),
	FOUR_KIND(8,"four of a kind"),
	FULL_HOUSE(7,"full house"),
	FLUSH(6,"flush"),
	STRAIGHT(5,"straight"),
	THREE_KIND(4,"three of a kind"),
	TWO_PAIRS(3,"two pairs"),
	PAIR(2,"pair"),
	HIGH_CARD(1,"high card");
	
	private int rank;

    private String name;
	
	PokerHandTypeEnum(int rank,String name){
		this.rank = rank;
		this.name = name;
	}
	
	public int getRank() {
		return this.rank;
	}

    public String getName() {
        return name;
    }
}
