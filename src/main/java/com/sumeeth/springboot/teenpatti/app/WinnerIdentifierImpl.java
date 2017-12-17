package com.sumeeth.springboot.teenpatti.app;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.Entity.Winner;
import com.sumeeth.springboot.teenpatti.winningstrategy.StrategyImplementor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class WinnerIdentifierImpl implements WinnerIdentifier {

    @Autowired
    private StrategyImplementor strategyImplementor;


    @Override
    public Optional<Winner> findWinner(List<Player> assignedPlayers) {
        return strategyImplementor.implement(assignedPlayers);
    }

}
