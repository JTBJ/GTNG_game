package academy.learnprogramming.game;

import academy.learnprogramming.custom_annotations.GuessCount;
import academy.learnprogramming.numberGenerator.NumberGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

    {/*/ == constants ==
    //private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    @Autowired
    private NumberGenerator numberGenerator;

    @Autowired
    @GuessCount
    private int guessCount;*/}

    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    private final int guessCount;
    private int number;

    @Setter
    private int guess;

    private int smallest;

    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    // == constructor ==
    //@Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    // == init method ==
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("In Game preDestroy()");
    }

    {// == constructors ==
    /*public GameImpl(){}

    public GameImpl(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }*/

    // == setter for dependency injection
    /*public void setNumberGenerator(NumberGenerator numberGenerator){
        this.numberGenerator = numberGenerator;
    }*/

    // == public methods ==
//    @Override
//    public int getNumber() {
//        return number;
//    }

    /*@Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }*/

    /*@Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }*/}

    @Override
    public void check() {
        checkValidNumberRange();
        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    /*@Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }*/

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
