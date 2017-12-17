package com.sumeeth.springboot.teenpatti.winningstrategy;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.Entity.Winner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StrategyImplementor {
    private List<WinningStrategy> winningStrategies;

    @Autowired
    public StrategyImplementor(List<WinningStrategy> newWinningStrategies) {
        this.winningStrategies = newWinningStrategies;
    }

    public Optional<Winner> implement(List<Player> assignedPlayers) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            Optional<Winner> winnerTemp = winningStrategy.execute(assignedPlayers);
            if (winnerTemp.isPresent()) {
                return winnerTemp;
            }
        }
        return Optional.empty();
    }

}
