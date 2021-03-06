package academy.learnprogramming.messageGenerator;

import academy.learnprogramming.game.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private final Game game;

    // == constructor ==
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == init method ==
    @PostConstruct
    public void logGame() {
        log.info("Game value {}", game);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber();
        }else if(game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        }else if(!game.isValidNumberRange()) {
            return "Invalid number range";
        }else if(game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        }else {
            String direction = "lower";
            if(game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return game.getRemainingGuesses() > 1 ? direction + "! You have " + game.getRemainingGuesses() + " guesses left"
                    : direction + "! You have " + game.getRemainingGuesses() + " guess left";
        }
    }
}
