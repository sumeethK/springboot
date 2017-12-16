package com.sumeeth.springboot.teenpatti.Entity;

import java.util.Optional;

public class Winner {
    private Optional<Player> player;
    private WIN_TYPE winType;

    public Winner(Optional<Player> player, WIN_TYPE winType) {
        this.player = player;
        this.winType = winType;
    }

    public Optional<Player> getPlayer() {
        return player;
    }

    public WIN_TYPE getWinType() {
        return winType;
    }

    public enum WIN_TYPE{
        SAME_CARD_NO,SAME_CARD_HIGH_WEIGHTAGE,SAME_COLOR, SAME_COLOR_HIGH_WEIGHTAGE
    }

    @Override
    public String toString() {
        return "Winner{" +
                "winType=" + winType +
                ",player=" + player +
                '}';
    }
}
