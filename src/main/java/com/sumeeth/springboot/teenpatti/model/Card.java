package com.sumeeth.springboot.teenpatti.model;

import java.util.Objects;
import java.util.Random;

public class Card {
    private Integer cardNo;
    private COLOR color;

    private TYPE cardType;

    public Card() {
    }

    public Card(Integer cardNo, COLOR color, TYPE cardType) {
        this.cardNo = cardNo;
        this.color = color;
        this.cardType = cardType;
    }

    public Integer getCardNo() {
        return cardNo;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardNo, card.cardNo) &&
                color == card.color &&
                cardType == card.cardType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(cardNo, color, cardType);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNo=" + cardNo +
                ", color=" + color +
                ", cardType=" + cardType +
                '}';
    }

    public TYPE getCardType() {
        return cardType;
    }

    public void setCardType(TYPE cardType) {
        this.cardType = cardType;
    }

    public enum COLOR {
        RED, BLACK;
        public static COLOR getSpecificColor(int i){
            return i<=26 ?RED:BLACK;
        }
        public static COLOR getRandomColor() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public enum TYPE {
        HEARTS, CLUB, SPADE, DIAMOND;

        public static TYPE getSpecificType(int i){
            return values()[i-1];
        }

        public static TYPE getRandomType() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }
}
