package com.sumeeth.springboot.teenpatti.Entity;

import com.sumeeth.springboot.teenpatti.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Player {
    private List<Card> cardList;
    private String name;
    private Integer cardCount;

    public Optional<Integer> getHighestCard(){
       return cardList.stream().map(card -> card.getCardNo()).max((a,b)->a-b);
    }

    public Player(){
        cardList = new ArrayList<>();
        name ="Sumeeth";
        cardCount = 0;
    }
    public Player(String plaeyerName){
        cardList = new ArrayList<>();
        name =plaeyerName;
        cardCount = 0;
    }

    public void incrementCardCount() {
        this.cardCount++;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCardCount() {
        return cardCount;
    }

    public void setCardCount(Integer cardCount) {
        this.cardCount = cardCount;
    }

    @Override
    public String toString() {
        return "Player{" +
                " cardCount=" + cardCount +
                ", name='" + name + '\'' +
                ",cardList=" + cardList +
                '}';
    }
}
