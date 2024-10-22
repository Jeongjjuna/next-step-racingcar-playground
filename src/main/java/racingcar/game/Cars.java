package racingcar.game;

import racingcar.exception.BaseException;

import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * 랜덤값을 어떻게 받을지 고민해야함
     * - 테스트하기 어려움
     * - 조건 변경하기 어려움
     */
    public void move(int trialCount) {
        Random random = new Random();

        for (Car car: cars) {
            int randomNumber = random.nextInt(0, 10);

            if (4 <= randomNumber) {
                car.moveForward();
            }
        }
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
