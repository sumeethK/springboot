package com.sumeeth.springboot.teenpatti.app;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.Entity.Winner;
import com.sumeeth.springboot.teenpatti.model.Card;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/teenpatti-context.xml"})
public class WinnerIdentifierImplTest extends TestCase {

    List<Player> playerList;
    @Autowired
    private WinnerIdentifier winnerIdentifier;

    {
        playerList = new ArrayList<>();
        playerList.add(new Player());
        playerList.add(new Player("Jhon"));
        playerList.add(new Player("Radhe"));
    }

    @Test
    public void testfindWinner() {
        distributeCards();
        Optional<Winner> winner = winnerIdentifier.findWinner(playerList);
        assertTrue("There should be atleast one winner", winner.isPresent());
        assertEquals("Winner should be Radhe.", "Radhe",
                winner.get().getPlayer().get().getName());
    }

    private void distributeCards() {
        List<Card> cardList1 = new ArrayList<>();
        cardList1.add(new Card(1, Card.COLOR.RED, Card.TYPE.DIAMOND));
        cardList1.add(new Card(8, Card.COLOR.RED, Card.TYPE.HEARTS));
        cardList1.add(new Card(1, Card.COLOR.RED, Card.TYPE.CLUB));
        playerList.get(0).setCardList(cardList1);
        playerList.get(0).setCardCount(3);
        List<Card> cardList2 = new ArrayList<>();
        cardList2.add(new Card(2, Card.COLOR.BLACK, Card.TYPE.SPADE));
        cardList2.add(new Card(4, Card.COLOR.RED, Card.TYPE.DIAMOND));
        cardList2.add(new Card(2, Card.COLOR.RED, Card.TYPE.DIAMOND));
        playerList.get(1).setCardList(cardList2);
        playerList.get(1).setCardCount(3);
        List<Card> cardList3 = new ArrayList<>();
        cardList3.add(new Card(3, Card.COLOR.BLACK, Card.TYPE.SPADE));
        cardList3.add(new Card(9, Card.COLOR.RED, Card.TYPE.DIAMOND));
        cardList3.add(new Card(3, Card.COLOR.RED, Card.TYPE.DIAMOND));
        playerList.get(2).setCardList(cardList3);
        playerList.get(2).setCardCount(3);
    }


}
