package racingcar.infrastructure;

import racingcar.domain.Count;
import racingcar.domain.car.Cars;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Cars getPlayerCars() {
        String input = scanner.nextLine();
        String[] names = input.split(",");

        return Cars.of(names);
    }

    @Override
    public Count getTrialCount() {
        String input = scanner.nextLine();
        return new Count(Integer.parseInt(input));
    }
}
