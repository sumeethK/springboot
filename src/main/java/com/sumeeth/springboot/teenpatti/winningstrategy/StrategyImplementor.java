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
        return winningStrategies.stream().map(strategy -> strategy.execute(assignedPlayers)).findFirst();
//        return winningStrategies.stream().filter(strategy -> ifWinnerFound(strategy,assignedPlayers)).findFirst();
    }

//    private Boolean ifWinnerFound(WinningStrategy strategy, List<Player> assignedPlayers){
//        return strategy.execute(assignedPlayers).isPresent();
//    }
}
