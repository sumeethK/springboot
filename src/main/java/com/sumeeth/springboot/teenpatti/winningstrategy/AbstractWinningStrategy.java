package com.sumeeth.springboot.teenpatti.winningstrategy;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.model.Card;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractWinningStrategy {
    Comparator<Player> highestSameCard = Comparator.comparing(p -> p.getHighestCard().get());
    Comparator<Player> highestSameColor = Comparator.comparing(p -> p.getHighestCard().get());


    protected boolean ifCradConsecutive(List<Card> cardList) {
        List<Card> cardListTemp = new ArrayList<>(cardList);
        cardListTemp.sort((c1, c2) -> c2.getCardNo() - c1.getCardNo());
        return cardListTemp.get(0).getCardNo() - 1 == cardListTemp.get(1).getCardNo()
                && cardListTemp.get(0).getCardNo() - 2 == cardListTemp.get(2).getCardNo();

    }
}
