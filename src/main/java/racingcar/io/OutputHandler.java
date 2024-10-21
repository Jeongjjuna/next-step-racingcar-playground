package racingcar.io;

import racingcar.game.Cars;

public interface OutputHandler {
    void showCarNamesInputComment();

    int showTrialCountInputComment();

    void showRacingGameResult(Cars players);

    void showWinner(Cars winners);
}
