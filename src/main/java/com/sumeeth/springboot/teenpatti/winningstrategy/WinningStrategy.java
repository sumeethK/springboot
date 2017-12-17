package com.sumeeth.springboot.teenpatti.winningstrategy;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.Entity.Winner;

import java.util.List;

public interface WinningStrategy {

    Winner execute(List<Player> assignedPlayers);
}
