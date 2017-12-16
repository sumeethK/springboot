package com.sumeeth.springboot.teenpatti.winningstrategy;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.Entity.Winner;
import com.sumeeth.springboot.teenpatti.model.Card;

import java.util.*;
import java.util.stream.Collectors;

public class WinnigStrategyImpl implements WinnigStrategy {

    Comparator<Player> highestSameCard = Comparator.comparing(p -> p.getHighestCard().get());

    Comparator<Player> highestSameColor = Comparator.comparing(p -> p.getHighestCard().get());

    @Override
    public Winner findWinner(List<Player> assignedPlayerList) {
        List<Player> elligibleSameCardWinners = assignedPlayerList.stream()
                .filter(p -> isPlayerHasSameCardNo(p.getCardList()))
                .collect(Collectors.toList());
        List<Player> elligibleSameColorWinners = assignedPlayerList.stream()
                .filter(p -> ifPlayerHasCardWIthSameColor(p.getCardList()))
                .collect(Collectors.toList());
        if (null != elligibleSameCardWinners && elligibleSameCardWinners.size() == 1) {
            return new Winner(Optional.ofNullable(elligibleSameCardWinners.get(0)), Winner.WIN_TYPE.SAME_CARD_NO);
        } else if (null != elligibleSameCardWinners && elligibleSameCardWinners.size() > 1) {
            return new Winner(elligibleSameCardWinners.stream()
                    .max(highestSameCard), Winner.WIN_TYPE.SAME_CARD_HIGH_WEIGHTAGE);
        } else if (null != elligibleSameColorWinners && elligibleSameColorWinners.size() == 1) {
            return new Winner(Optional.ofNullable(elligibleSameColorWinners.get(0)), Winner.WIN_TYPE.SAME_COLOR);
        } else if (null != elligibleSameColorWinners && elligibleSameColorWinners.size() > 1) {
            return new Winner(elligibleSameColorWinners.stream()
                    .max(highestSameColor), Winner.WIN_TYPE.SAME_COLOR_HIGH_WEIGHTAGE);
        } else return null;
    }

    private boolean isPlayerElligible(Player player) {
        return isPlayerHasSameCardNo(player.getCardList()) ? true : ifPlayerHasCardWIthSameColor(player.getCardList());
    }

    private boolean ifPlayerHasCardWIthSameColor(List<Card> cardList) {
        return (cardList.get(0).getColor().equals(cardList.get(1).getColor()) && cardList.get(0).getColor().equals(cardList.get(2).getColor()));
    }

    private boolean isPlayerHasSameCardNo(List<Card> cardList) {
        return ifAllSameNo(cardList);
    }

    private boolean ifAllSameNo(List<Card> cardList) {
        return (cardList.get(0).getCardNo() == cardList.get(1).getCardNo() &&
                cardList.get(0).getCardNo() == cardList.get(2).getCardNo());
    }

    private boolean ifCradConsecutive(List<Card> cardList) {
        List<Card> cardListTemp = new ArrayList<>(cardList);
        Collections.sort(cardListTemp, (c1, c2) -> {
            return c2.getCardNo() - c1.getCardNo();
        });
        return cardListTemp.get(0).getCardNo() - 1 == cardListTemp.get(1).getCardNo()
                && cardListTemp.get(0).getCardNo() - 2 == cardListTemp.get(2).getCardNo();

    }
}
