package racingcar;

import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

public class Application {

    public static void main(String[] args) {

        MoveStrategy moveStrategy = new RandomMoveStrategy();

        RacingCarGame racingCarGame = new RacingCarGame(moveStrategy);
        racingCarGame.run();
    }
}
