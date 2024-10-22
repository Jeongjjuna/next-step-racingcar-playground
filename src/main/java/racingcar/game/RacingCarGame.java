package racingcar.game;


import racingcar.game.car.Cars;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.strategy.MoveStrategy;

public class RacingCarGame implements GameInitializable, GameRunnable {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final MoveStrategy moveStrategy;

    public RacingCarGame(InputHandler inputHandler, OutputHandler outputHandler, MoveStrategy moveStrategy) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void run() {
        outputHandler.showCarNamesInputComment(); // 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
        Cars playerCars = inputHandler.getPlayerCars();

        outputHandler.showTrialCountInputComment(); // 시도할 회수는 몇회인가요?
        int trialCount = inputHandler.getTrialCount();

        outputHandler.showGameResultComment();
        while (trialCount != 0) {
            race(playerCars);
            outputHandler.showRacingGameResult(playerCars); // 실행 결과
            trialCount -= 1;
        }

        Cars winners = playerCars.findWinner();
        outputHandler.showWinner(winners);
    }

    private void race(Cars players) {
        players.moveBy(moveStrategy);
    }

}
