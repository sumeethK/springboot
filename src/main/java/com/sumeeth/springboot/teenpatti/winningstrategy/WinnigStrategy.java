package com.sumeeth.springboot.teenpatti.winningstrategy;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.Entity.Winner;

import java.util.List;

public interface WinnigStrategy {

    Winner findWinner(List<Player> assignedPlayerList);
}
