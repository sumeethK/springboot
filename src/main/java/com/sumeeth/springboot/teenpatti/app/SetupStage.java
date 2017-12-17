package com.sumeeth.springboot.teenpatti.app;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.model.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SetupStage {

    public List<Card> setUpCard() {
        List<Card> cardList = new ArrayList<>();
        int count = 1;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13 && count <= 52; j++) {
                count++;
                Card card = new Card(j, Card.COLOR.getSpecificColor(count), Card.TYPE.getSpecificType(i));
                cardList.add(card);
            }
        }

        Set<Card> cards = new HashSet<>(cardList);
        if (cards.size() != 52) {
            throw new RuntimeException("Deck has duplicate or more than 52 cards!");
        }
        return cardList;
    }

    public List<Player> setupPlayer() {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player());
        playerList.add(new Player("Jhon"));
        playerList.add(new Player("Radhe"));
        playerList.add(new Player("Sujit"));
        playerList.add(new Player("Nicky"));
        playerList.add(new Player("Dolly"));
        playerList.add(new Player("Den"));
        playerList.add(new Player("Jack"));
        playerList.add(new Player("Varun"));
        playerList.add(new Player("Michael"));
        playerList.add(new Player("DEV"));
        playerList.add(new Player("PIKU"));
        playerList.add(new Player("Annaaaaa"));
        playerList.add(new Player("Roy"));
        playerList.add(new Player("Deepak"));
        return playerList;

    }

}
