package academy.learnprogramming.console;

import academy.learnprogramming.config.AppConfig;
import academy.learnprogramming.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // create context (container)
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(GameConfig.class);

        // get numberGenerator bean from context (container)
        /*NumberGenerator numberGenerator =
                context.getBean(NumberGenerator.class);

        // call method next() to get a random number
        int number = numberGenerator.next();

        // log generate number
        log.info("number = {}", number);

        // get game bean from context (container)
        Game game = context.getBean(Game.class);

        // get messageGenerator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        // call methods on messageGenerator
        System.out.println(messageGenerator.getMainMessage());
        System.out.println(messageGenerator.getResultMessage());
        */

        // close context (container)
        context.close();
    }
}
