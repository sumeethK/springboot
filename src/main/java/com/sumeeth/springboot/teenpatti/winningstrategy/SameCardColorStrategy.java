package com.sumeeth.springboot.teenpatti.winningstrategy;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.Entity.Winner;
import com.sumeeth.springboot.teenpatti.model.Card;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SameCardColorStrategy extends AbstractWinningStrategy implements WinningStrategy {
    @Override
    public Optional<Winner> execute(List<Player> assignedPlayers) {
        List<Player> elligibleSameColorWinners = assignedPlayers.stream()
                .filter(p -> ifPlayerHasCardWIthSameColor(p.getCardList()))
                .collect(Collectors.toList());
        if (null != elligibleSameColorWinners && elligibleSameColorWinners.size() == 1) {
            return Optional.of(new Winner(Optional.ofNullable(elligibleSameColorWinners.get(0)), Winner.WIN_TYPE.SAME_COLOR));
        } else if (null != elligibleSameColorWinners && elligibleSameColorWinners.size() > 1) {
            return Optional.of(new Winner(elligibleSameColorWinners.stream()
                    .max(highestSameColor), Winner.WIN_TYPE.SAME_COLOR_HIGHER_WEIGHTAGE));
        }
        return Optional.empty();
    }

    private boolean ifPlayerHasCardWIthSameColor(List<Card> cardList) {
        return (cardList.get(0).getColor().equals(cardList.get(1).getColor())
                && cardList.get(0).getColor().equals(cardList.get(2).getColor()));
    }

}
