package com.sumeeth.springboot.teenpatti.winningstrategy;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.Entity.Winner;

import java.util.List;
import java.util.Optional;

public interface WinningStrategy {

    Optional<Winner> execute(List<Player> assignedPlayers);
}
