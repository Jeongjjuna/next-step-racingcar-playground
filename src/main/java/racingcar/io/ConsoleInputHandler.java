package racingcar.io;

import racingcar.game.Count;
import racingcar.game.car.Car;
import racingcar.game.car.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Cars getPlayerCars() {
        String input = scanner.nextLine();
        String[] names = input.split(",");

        List<Car> cars = Arrays.stream(names)
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }

    @Override
    public Count getTrialCount() {
        String input = scanner.nextLine();
        return new Count(Integer.parseInt(input));
    }
}
