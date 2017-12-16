package com.sumeeth.springboot.teenpatti.distributor;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.model.Card;

import java.util.List;

public interface Distributor {

    List<Player> distribute(List<Player> playerList, List<Card> cardList);
}
