package racingcar;

import racingcar.game.MoveCondition;
import racingcar.game.RacingCarGame;
import racingcar.game.RandomMoveCondition;
import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class Application {

    public static void main(String[] args) {

        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        MoveCondition moveCondition = new RandomMoveCondition();

        RacingCarGame racingCarGame = new RacingCarGame(
                inputHandler,
                outputHandler,
                moveCondition
        );
        racingCarGame.run();
    }
}
