package com.poker;

import com.poker.enums.PokerHandTypeEnum;

import java.util.*;
import java.util.stream.Collectors;


public class Player {
    private String name;
    private List<Card> cards;

    public PokerHandTypeEnum getPokerHandType() {
        return pokerHandType;
    }

    private PokerHandTypeEnum pokerHandType;
    private String winningReason;

    public Player(String name, List<Card> cards) throws Exception {
        if (cards != null && cards.size() == 5) {
            this.name = name;
            this.cards = sortDesc(cards);
            pokerHandType = getHandType(cards);
        }else {
            throw new Exception("A player should have five cards.");
        }
    }

    public String getName() {
        return name;
    }

    public int compareTo(Player player2){
        if (this.pokerHandType.getRank() > player2.pokerHandType.getRank()) {
            return 1;
        } else if (this.pokerHandType.getRank() < player2.pokerHandType.getRank()) {
            return -1;
        } else {
            return compareTwoPlayersWithSameHandType(this, player2);
        }
    }

    private PokerHandTypeEnum getHandType(List<Card> cards) {
        boolean isSameSuit = isSameSuit(cards);
        this.winningReason = cards.get(0).getValue();
        if (isConsecutive(cards)) {
            if (isSameSuit) {
                return PokerHandTypeEnum.STRAIGHT_FLUSH;
            } else {
                return PokerHandTypeEnum.STRAIGHT;
            }
        } else {
            if (isSameSuit) {
                return PokerHandTypeEnum.FLUSH;
            }
            LinkedHashMap<String, List<Card>> groupedCards = groupByValueAndSortByQuantityAndValue(cards);
            int size = groupedCards.size();
            Iterator<Map.Entry<String, List<Card>>> iterator = groupedCards.entrySet().iterator();
            Map.Entry<String, List<Card>> firstEntry = iterator.next();
            List<Card> firstCardList = firstEntry.getValue();
            Map.Entry<String, List<Card>> secondEntry = iterator.next();
            List<Card> secondCardList = secondEntry.getValue();
            switch (firstCardList.size()) {
                case 4:
                    this.winningReason = "four " + firstCardList.get(0).getValue() + " ";
                    return PokerHandTypeEnum.FOUR_KIND;
                case 3:
                    if (size == 2) {
                        this.winningReason = firstCardList.get(0).getValue() + " over " + secondCardList.get(0).getValue();
                        return PokerHandTypeEnum.FULL_HOUSE;
                    } else {
                        this.winningReason = "three " + firstCardList.get(0).getValue();
                        return PokerHandTypeEnum.THREE_KIND;
                    }
                case 2:
                    if (size == 3) {
                        this.winningReason = "pair " + firstCardList.get(0).getValue() + " and pair " + secondCardList.get(0).getValue();
                        return PokerHandTypeEnum.TWO_PAIRS;
                    } else {
                        this.winningReason = "pair " + firstCardList.get(0).getValue();
                        return PokerHandTypeEnum.PAIR;
                    }
            }
        }
        return PokerHandTypeEnum.HIGH_CARD;
    }

    private int compareTwoPlayersWithSameHandType(Player p1, Player p2) {
        int result = 0;
        switch (p1.pokerHandType) {
            case STRAIGHT_FLUSH:
            case FLUSH:
            case STRAIGHT:
            case HIGH_CARD:
                for (int i = 0; i < 5; i++) {
                    if (p1.cards.get(i).getIntValue() > p2.cards.get(i).getIntValue()) {
                        p1.winningReason = p1.cards.get(i).getValue();
                        result = 1;
                        break;
                    } else if (p1.cards.get(i).getIntValue() < p2.cards.get(i).getIntValue()) {
                        p2.winningReason = p2.cards.get(i).getValue();
                        result = -1;
                        break;
                    }
                }
                break;
            case FOUR_KIND:
            case FULL_HOUSE:
            case THREE_KIND:
            case TWO_PAIRS:
            case PAIR:
                LinkedHashMap<String, List<Card>> player1CardMap = groupByValueAndSortByQuantityAndValue(p1.cards);
                LinkedHashMap<String, List<Card>> player2CardMap = groupByValueAndSortByQuantityAndValue(p2.cards);
                Iterator<Map.Entry<String, List<Card>>> iterator1 = player1CardMap.entrySet().iterator();
                Iterator<Map.Entry<String, List<Card>>> iterator2 = player2CardMap.entrySet().iterator();
                while (iterator1.hasNext() && iterator2.hasNext()) {
                    Map.Entry<String, List<Card>> entry1 = iterator1.next();
                    Map.Entry<String, List<Card>> entry2 = iterator2.next();
                    if (entry1.getValue().get(0).getIntValue() > entry2.getValue().get(0).getIntValue()) {
                        p1.winningReason = entry1.getValue().size() > 1 ? entry1.getValue().size() + " of " + entry1.getValue().get(0).getValue() : entry1.getValue().get(0).getValue();
                        result = 1;
                        break;
                    } else if (entry1.getValue().get(0).getIntValue() < entry2.getValue().get(0).getIntValue()) {
                        p2.winningReason = entry2.getValue().size() > 1 ? entry2.getValue().size() + " of " + entry2.getValue().get(0).getValue() : entry2.getValue().get(0).getValue();
                        result = -1;
                        break;
                    }
                }
                break;

        }
        return result;
    }

    public String printWinningMessage() {
        return this.name + " wins. - with " + pokerHandType.getName() + " :" + winningReason;
    }


    /**
     * Retourner une liste de cards dans l'ordre décroissant par leurs valeurs
     *
     * @param cards une liste de cards
     * @return List<Card>
     */
    private static List<Card> sortDesc(List<Card> cards) {
        if (cards != null) {
            return cards.stream().sorted(Comparator.comparingInt(Card::getIntValue).reversed()).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    /**
     * Retourner une valeur boolean
     * Si les valeurs de cards sont consécutifs, retourner true.
     * Sinon, retourner false
     *
     * @param cards une liste de cards dans l'ordre croissant
     * @return boolean
     */
    private static boolean isConsecutive(List<Card> cards) {
        if (cards != null) {
            int total = cards.stream().mapToInt(Card::getIntValue).sum();
            int n = cards.size();
            int totalExpected = (cards.get(0).getIntValue() + cards.get(4).getIntValue()) * n / 2;
            return total == totalExpected;
        } else {
            return false;
        }
    }

    /**
     * Retourner une valeur boolean
     * Si toutes les cards sont de même suit, retourner true
     * Sinon, retourner false
     *
     * @param cards une liste de cards
     * @return boolean
     */
    private boolean isSameSuit(List<Card> cards) {
        if (cards != null && !cards.isEmpty()) {
            return cards.stream().map(c -> c.getSuit().getName()).distinct().count() == 1;
        } else {
            return false;
        }
    }

    /**
     * Retourner une LinkedHashMap
     * Grouper les cartes par leurs valeurs et lister par nombre de cartes d'abord et ensuite leurs valeurs dans l'ordre décroissant
     *
     * @param cards une liste de cards
     * @return LinkedHashMap<String, List < Card>>
     */
    private LinkedHashMap<String, List<Card>> groupByValueAndSortByQuantityAndValue(List<Card> cards) {
        if (cards != null) {
            Map<String, List<Card>> map = cards.stream().collect(Collectors.groupingBy(Card::getValue));
            return map.entrySet().stream().sorted(Player::compareBySizeThenValue).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        } else {
            return null;
        }
    }

    private static int compareBySizeThenValue(Map.Entry<String, List<Card>> e1, Map.Entry<String, List<Card>> e2) {
        if (e1.getValue().size() == e2.getValue().size()) {
            return e2.getValue().get(0).getIntValue() - e1.getValue().get(0).getIntValue();
        } else {
            return e2.getValue().size() - e1.getValue().size();
        }
    }
}
