package com.sumeeth.springboot.teenpatti.winningstrategy;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.Entity.Winner;
import com.sumeeth.springboot.teenpatti.model.Card;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class SameCardNumberStrategy extends AbstractWinningStrategy implements WinningStrategy {
    @Override
    public Winner execute(List<Player> assignedPlayers) {
        List<Player> elligibleSameCardWinners = assignedPlayers.stream()
                .filter(p -> ifPlayerHasSameCardNo(p.getCardList()))
                .collect(Collectors.toList());
        if (null != elligibleSameCardWinners && elligibleSameCardWinners.size() == 1) {
            return new Winner(Optional.ofNullable(elligibleSameCardWinners.get(0)), Winner.WIN_TYPE.SAME_CARD_NO);
        } else if (null != elligibleSameCardWinners && elligibleSameCardWinners.size() > 1) {
            return new Winner(elligibleSameCardWinners.stream()
                    .max(highestSameCard), Winner.WIN_TYPE.SAME_CARD_HIGHER_WEIGHTAGE);
        }
        return null;
    }

    private boolean ifPlayerHasSameCardNo(List<Card> cardList) {
        return (Objects.equals(cardList.get(0).getCardNo(), cardList.get(1).getCardNo()) &&
                Objects.equals(cardList.get(0).getCardNo(), cardList.get(2).getCardNo()));
    }
}
