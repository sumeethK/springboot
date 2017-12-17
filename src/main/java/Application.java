import com.sumeeth.springboot.teenpatti.app.SetupStage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring/teenpatti-context.xml"})
@ComponentScan({"com.sumeeth.springboot"})
public class Application {

    public static void main(String[] args) {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        SetupStage setupStage = (SetupStage) context.getBean("setupStage");


//        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
//
//        // Send a message with a POJO - the template reuse the message converter
//        System.out.println("Sending an email message.");
//        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
    }

}