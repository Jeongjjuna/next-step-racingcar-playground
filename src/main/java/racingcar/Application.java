package racingcar;

import racingcar.game.RacingCarGame;
import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class Application {

    public static void main(String[] args) {

        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        RacingCarGame racingCarGame = new RacingCarGame(
                inputHandler,
                outputHandler
        );
        racingCarGame.run();
    }
}
