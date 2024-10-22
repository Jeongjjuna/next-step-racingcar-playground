package racingcar;

import racingcar.strategy.MoveStrategy;
import racingcar.game.RacingCarGame;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class Application {

    public static void main(String[] args) {

        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        RacingCarGame racingCarGame = new RacingCarGame(
                inputHandler,
                outputHandler,
                moveStrategy
        );
        racingCarGame.run();
    }
}
