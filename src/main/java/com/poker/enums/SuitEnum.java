package com.poker.enums;

public enum SuitEnum {
    CLUB("C"), DIAMOND("D"), HEART("H"), SPADE("S");
    private String name;

    public String getName() {
        return name;
    }

    SuitEnum(String name) {
        this.name = name;
    }

    public static SuitEnum getEnumByName(String name) {
        for (SuitEnum e : SuitEnum.values()) {
            if (name.equals(e.name)) return e;
        }
        return null;
    }

}
