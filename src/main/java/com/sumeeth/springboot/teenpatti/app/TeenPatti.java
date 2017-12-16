package com.sumeeth.springboot.teenpatti.app;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.distributor.Distributor;
import com.sumeeth.springboot.teenpatti.distributor.DistributorImpl;
import com.sumeeth.springboot.teenpatti.model.Card;
import com.sumeeth.springboot.teenpatti.winningstrategy.WinnigStrategy;
import com.sumeeth.springboot.teenpatti.winningstrategy.WinnigStrategyImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeenPatti {

    public static void main(String[] args) {
        List<Card> cardList = new ArrayList<>();
        int count = 1;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13 && count <= 52; j++) {
                count++;
                Card card = new Card(j, Card.COLOR.getSpecificColor(count), Card.TYPE.getSpecificType(i));
                cardList.add(card);
            }
        }

        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player());
        playerList.add(new Player("Jhon"));
        playerList.add(new Player("Radhe"));


        Distributor distributor = new DistributorImpl();
        List<Player> assignedPlayer = distributor.distribute(playerList, cardList);
        assignedPlayer.forEach(System.out::println);

        WinnigStrategy winnigStrategy = new WinnigStrategyImpl();
        System.out.println(winnigStrategy.findWinner(assignedPlayer));

    }


}
