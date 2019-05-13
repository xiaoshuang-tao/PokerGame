package com.poker;

public enum SuitEnum {
    CLUB("C"), DIAMOND("D"), HEART("H"), SPADE("S");
    private String name;

    public String getName() {
        return name;
    }

    SuitEnum(String name) {
        this.name = name;
    }
}
