package racingcar.io;

import racingcar.game.Count;
import racingcar.game.car.Cars;

public interface InputHandler {
    Cars getPlayerCars();

    Count getTrialCount();
}
