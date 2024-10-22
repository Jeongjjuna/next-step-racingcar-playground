package racingcar;


import racingcar.domain.Count;
import racingcar.domain.car.Cars;
import racingcar.exception.BaseException;
import racingcar.game.GameInitializable;
import racingcar.game.GameRunnable;
import racingcar.infrastructure.RacingCarIOHandler;
import racingcar.strategy.MoveStrategy;

import java.util.logging.Logger;

public class RacingCarGame implements GameInitializable, GameRunnable {

    private static final Logger LOGGER = Logger.getLogger(RacingCarGame.class.getName());

    private final RacingCarIOHandler racingCarIOHandler = new RacingCarIOHandler();
    private final MoveStrategy moveStrategy;

    public RacingCarGame(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void run() {
        try {
            Cars playerCars = racingCarIOHandler.askRacingCarNameSelecting();

            Count count = racingCarIOHandler.askRacingTrialCountSelecting();

            racingCarIOHandler.showGameResultComment();

            while (count.isRemain()) {
                count = raceAllPlayerAndCountDown(playerCars, count);
            }

            Cars winners = playerCars.findWinner();

            racingCarIOHandler.showWinner(winners);
        } catch (BaseException e) {
            LOGGER.info(e.getMessage());
        } catch (Exception e) {
            LOGGER.severe("[ERROR] Internal System Error");
        }
    }

    private Count raceAllPlayerAndCountDown(Cars playerCars, Count count) {
        race(playerCars);

        racingCarIOHandler.showRacingGameResult(playerCars);

        return count.down();
    }

    private void race(Cars players) {
        players.moveBy(moveStrategy);
    }

}
