package racingcar.infrastructure;

import racingcar.domain.car.Cars;

public interface OutputHandler {
    void showCarNamesInputComment();

    void showTrialCountInputComment();

    void showRacingGameResult(Cars players);

    void showWinner(Cars winners);

    void showGameResultComment();
}
