package racingcar.infrastructure;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;

import java.util.List;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void showCarNamesInputComment() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    @Override
    public void showTrialCountInputComment() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void showRacingGameResult(Cars players) {
        List<Car> cars = players.getCars();
        for (Car car: cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition().getPosition()));
        }
        System.out.println();
    }

    @Override
    public void showWinner(Cars winners) {
        List<String> winnerNames = winners.getCars().stream()
                .map(Car::getName)
                .map(CarName::getName)
                .toList();

        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    @Override
    public void showGameResultComment() {
        System.out.println("실행 결과");
    }
}
