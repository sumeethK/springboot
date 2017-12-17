package com.sumeeth.springboot.teenpatti.winningstrategy;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.Entity.Winner;
import com.sumeeth.springboot.teenpatti.model.Card;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SameCardTypeStrategy extends AbstractWinningStrategy implements WinningStrategy {
    @Override
    public Optional<Winner> execute(List<Player> assignedPlayers) {
        List<Player> elligibleSameCardTypeWinners = assignedPlayers.stream()
                .filter(p -> ifPlayerHasSameCardType(p.getCardList()))
                .collect(Collectors.toList());
        if (null != elligibleSameCardTypeWinners && elligibleSameCardTypeWinners.size() == 1) {
            return Optional.of(new Winner(Optional.ofNullable(elligibleSameCardTypeWinners.get(0)), Winner.WIN_TYPE.SAME_CARD_TYPE));
        } else if (null != elligibleSameCardTypeWinners && elligibleSameCardTypeWinners.size() > 1) {
            return Optional.of(new Winner(elligibleSameCardTypeWinners.stream()
                    .max(highestSameColor), Winner.WIN_TYPE.SAME_CARD_TYPE_HIGHER_WEIGHTAGE));
        }
        return Optional.empty();
    }

    private boolean ifPlayerHasSameCardType(List<Card> cardList) {
        return (cardList.get(0).getCardType().equals(cardList.get(1).getCardType())
                && cardList.get(0).getCardType().equals(cardList.get(2).getCardType()));
    }

}
