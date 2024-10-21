package racingcar.game;


import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class RacingCarGame implements GameInitializable, GameRunnable {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingCarGame(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void run() {
        outputHandler.showCarNamesInputComment(); // 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
        Cars players = inputHandler.getPlayCars();

        int trialCount = outputHandler.showTrialCountInputComment(); // 시도할 회수는 몇회인가요?

        race(players, trialCount);

        outputHandler.showRacingGameResult(players); // 실행 결과

        Cars winners = players.findWinner();
        outputHandler.showWinner(winners);
    }

    private void race(Cars players, int trialCount) {
        players.move(trialCount);
    }

}
