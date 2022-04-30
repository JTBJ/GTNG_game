package academy.learnprogramming.config;

import academy.learnprogramming.game.Game;
import academy.learnprogramming.game.GameImpl;
import academy.learnprogramming.messageGenerator.MessageGenerator;
import academy.learnprogramming.messageGenerator.MessageGeneratorImpl;
import academy.learnprogramming.numberGenerator.NumberGenerator;
import academy.learnprogramming.numberGenerator.NumberGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration class specifies the configuration of the spring container, capable of replacing
 * the legacy XML based configuration. @ComponentScan tells the container to scan the package passed
 * and sub-packages for classes headed with the @Component annotation and register those classes as
 * beans with the spring container. An alternative to using @ComponentScan / @Component is to define
 * the bean definitions within the container class, the one headed with the @Configuration annotation.
 */

@Configuration
@ComponentScan("academy.learnprogramming")
public class AppConfig {

    // == bean definitions ==
    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }
}
