package racingcar.infrastructure;

import racingcar.domain.Count;
import racingcar.domain.car.Cars;

public class RacingCarIOHandler {
    private final InputHandler inputHandler = new ConsoleInputHandler();
    private final OutputHandler outputHandler = new ConsoleOutputHandler();

    public Cars askRacingCarNameSelecting() {
        outputHandler.showCarNamesInputComment();
        return inputHandler.getPlayerCars();
    }

    public Count askRacingTrialCountSelecting() {
        outputHandler.showTrialCountInputComment();
        return inputHandler.getTrialCount();
    }

    public void showGameResultComment() {
        outputHandler.showGameResultComment();
    }

    public void showRacingGameResult(Cars playerCars) {
        outputHandler.showRacingGameResult(playerCars);
    }

    public void showWinner(Cars winners) {
        outputHandler.showWinner(winners);
    }
}
