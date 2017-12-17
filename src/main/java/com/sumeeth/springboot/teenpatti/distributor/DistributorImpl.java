package com.sumeeth.springboot.teenpatti.distributor;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.model.Card;

import java.util.List;
import java.util.Random;

public class DistributorImpl implements Distributor {
    @Override
    public List<Player> distribute(List<Player> playerList, List<Card> cardList) {
        if (playerList.size() > 17) {
            throw new RuntimeException("No. of players can't be more than 17");
        }
        playerList.forEach(player -> assignCards(player, cardList));
        System.out.println("Card left after distribution :" + cardList.size());
        System.out.println("Room for more  :" + cardList.size() / 3);
        return playerList;
    }


    private void assignCards(Player player, List<Card> cardList) {
        Random random = new Random();
        int cardSize = cardList.size()-1;
        while (player.getCardCount() < 3) {
            int cardNo = random.nextInt(cardSize) + 1;
            player.getCardList().add(cardList.get(cardNo));
            cardList.remove(cardNo);
            cardSize--;
            player.incrementCard();
        }

    }


}
