package racingcar.infrastructure;

import racingcar.domain.Count;
import racingcar.domain.car.Cars;

public interface InputHandler {
    Cars getPlayerCars();

    Count getTrialCount();
}
