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

        int trialCount = racingCarIOHandler.askRacingTrialCountSelecting();

        racingCarIOHandler.showGameResultComment();

        while (trialCount != 0) {
            race(playerCars);

            racingCarIOHandler.showRacingGameResult(playerCars);

            trialCount -= 1;
        }

        Cars winners = playerCars.findWinner();
        racingCarIOHandler.showWinner(winners);
    }

    private void race(Cars players) {
        players.moveBy(moveStrategy);
    }

}
