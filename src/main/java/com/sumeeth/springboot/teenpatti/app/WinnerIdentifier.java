package com.sumeeth.springboot.teenpatti.app;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.Entity.Winner;

import java.util.List;
import java.util.Optional;

public interface WinnerIdentifier {

    Optional<Winner> findWinner(List<Player> assignedPlayers);
}
