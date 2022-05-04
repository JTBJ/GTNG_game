package academy.learnprogramming.config;

import academy.learnprogramming.custom_annotations.GuessCount;
import academy.learnprogramming.custom_annotations.MaxNumber;
import academy.learnprogramming.custom_annotations.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Configuration class specifies the configuration of the spring container, capable of replacing
 * the legacy XML based configuration. @ComponentScan tells the container to scan the package passed
 * and sub-packages for classes headed with the @Component annotation and register those classes as
 * beans with the spring container. An alternative to using @ComponentScan / @Component is to define
 * the bean definitions within the container class, the one headed with the @Configuration annotation.
 */
@Configuration
@ComponentScan("academy.learnprogramming")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:10}")
    private int minNumber;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }
}
