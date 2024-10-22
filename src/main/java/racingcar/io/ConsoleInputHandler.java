package racingcar.io;

import racingcar.game.Car;
import racingcar.game.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Cars getPlayerCars() {
        // pobi,crong,honux
        String input = scanner.nextLine();
        String[] names = input.split(",");

        List<Car> cars = Arrays.stream(names)
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }

    @Override
    public int getTrialCount() {
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
