package com.sumeeth.springboot.async.listeners;

import com.sumeeth.springboot.async.model.Email;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.Session;
@Component
public class TaskListener {

    private static final Log log = LogFactory.getLog(TaskListener.class);

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(@Payload Email email, @Headers MessageHeaders headers,
                               Message message, Session session) {
        log.info("Received <" + email + ">");
    }
}
