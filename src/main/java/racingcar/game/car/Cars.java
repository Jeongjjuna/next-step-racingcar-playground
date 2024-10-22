package racingcar.game.car;

import racingcar.exception.BaseException;
import racingcar.game.MoveCondition;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveBy(MoveCondition moveCondition) {
        cars.stream()
                .filter(car -> moveCondition.canGo())
                .forEach(Car::moveForward);
    }

    public Cars findWinner() {
        CarPosition maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(CarPosition::compareTo)
                .orElseThrow(() -> new BaseException("[ERROR] 승리자를 찾을 수 없음."));

        List<Car> winners = cars.stream()
                .filter(car -> car.isIn(maxPosition))
                .toList();

        return new Cars(winners);
    }

    public List<Car> getCars() {
        return cars;
    }
}
