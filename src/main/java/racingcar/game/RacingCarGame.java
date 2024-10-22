package racingcar.game;


import racingcar.game.car.Cars;
import racingcar.io.RacingCarIOHandler;
import racingcar.strategy.MoveStrategy;

public class RacingCarGame implements GameInitializable, GameRunnable {

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
        Cars playerCars = racingCarIOHandler.askRacingCarNameSelecting();

        Count count = racingCarIOHandler.askRacingTrialCountSelecting();

        racingCarIOHandler.showGameResultComment();

        while (count.isRemain()) {
            count = raceAllPlayerAndCountDown(playerCars, count);
        }

        Cars winners = playerCars.findWinner();

        racingCarIOHandler.showWinner(winners);
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
