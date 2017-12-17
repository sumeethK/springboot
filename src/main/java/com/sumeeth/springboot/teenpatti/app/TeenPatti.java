package com.sumeeth.springboot.teenpatti.app;

import com.sumeeth.springboot.teenpatti.Entity.Player;
import com.sumeeth.springboot.teenpatti.distributor.Distributor;
import com.sumeeth.springboot.teenpatti.model.Card;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Configuration
@ComponentScan({"com.sumeeth.springboot"})
public class TeenPatti {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring/teenpatti-context.xml");
        WinnerIdentifier winnerIdentifier = (WinnerIdentifier) context.getBean("winnerIdentifier");

        SetupStage setupStage = (SetupStage) context.getBean("stage");
        List<Card> cardList = setupStage.setUpCard();
        List<Player> playerList = setupStage.setupPlayer();


        Distributor distributor = (Distributor) context.getBean("distributor");
        List<Player> assignedPlayer = distributor.distribute(playerList, cardList);
        assignedPlayer.forEach(System.out::println);

//        WinnerIdentifier winnigStrategy = new WinnerIdentifierImpl();
//        System.out.println(winnigStrategy.findWinner(assignedPlayer));

        System.out.println("" + winnerIdentifier.findWinner(assignedPlayer));

    }


}
