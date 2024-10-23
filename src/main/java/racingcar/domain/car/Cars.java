package racingcar.domain.car;

import racingcar.exception.BaseException;
import racingcar.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of(String[] names) {
        List<Car> cars = convertCarsFrom(names);
        return new Cars(cars);
    }

    private static List<Car> convertCarsFrom(String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .toList();
    }

    public void moveBy(MoveStrategy moveStrategy) {
        cars.stream()
                .filter(car -> moveStrategy.canGo())
                .forEach(Car::moveForward);
    }

    public Cars findWinner() {
        CarPosition maxPosition = findMaxPosition();

        List<Car> winners = cars.stream()
                .filter(car -> car.isIn(maxPosition))
                .toList();
        return Cars.of(winners);
    }

    public List<Car> getCars() {
        return cars;
    }

    private CarPosition findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(CarPosition::compareTo)
                .orElseThrow(() -> new BaseException("[ERROR] 승리자를 찾을 수 없음."));
    }
}
