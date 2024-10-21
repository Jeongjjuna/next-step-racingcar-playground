package racingcar.io;

import racingcar.game.Cars;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void showCarNamesInputComment() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    @Override
    public int showTrialCountInputComment() {
        return 0;
    }

    @Override
    public void showRacingGameResult(Cars players) {

    }

    @Override
    public void showWinner(Cars winners) {

    }
}
