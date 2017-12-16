package com.sumeeth.springboot.resources;

import com.sumeeth.springboot.async.model.Email;
import org.apache.activemq.util.StopWatch;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.concurrent.CompletableFuture.runAsync;

@RestController
@RequestMapping("/email")
public class JMSDemo {
    private static final Log log = LogFactory.getLog(JMSDemo.class);


    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/send")
    public String send() {
        StopWatch stopWatch = new StopWatch();

        System.out.println("Sending a transaction.");
        // Post message to the message queue named "OrderTransactionQueue"
        log.info("Sending Mail.... ");
       runAsync(()->
               jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"))
       );
        stopWatch.stop();

        return String.valueOf(stopWatch.taken());

    }

}
