package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarPosition;
import racingcar.domain.car.Cars;
import racingcar.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("[Cars] 단위테스트")
class CarsTest {


    @DisplayName("승리 플레이어들을 구할 수 있다.")
    @Test
    void 플레이어들중_승리자들_구하기() {
        // given
        List<Car> carList = List.of(
                new Car("name1", 4),
                new Car("name2", 5),
                new Car("name2", 5)
        );
        Cars cars = Cars.of(carList);

        // when
        Cars winners = cars.findWinner();

        // then
        assertThat(winners.getCars().size()).isEqualTo(2);
    }


    @DisplayName("자동차 목록을 알 수 있다.")
    @Test
    void 자동차_목록_구하기() {
        // given
        List<Car> carList = List.of(
                new Car("name1", 4),
                new Car("name2", 5),
                new Car("name2", 5)
        );
        Cars cars = Cars.of(carList);

        // when
        List<Car> findCars = cars.getCars();

        // then
        assertThat(findCars.size()).isEqualTo(3);
    }

    @DisplayName("자동차가 조건에 따라 전진할 수 있다.")
    @Test
    void 자동차가_조건에따라_전진한다() {
        // given
        List<Car> carList = List.of(
                new Car("name1", 0),
                new Car("name2", 0),
                new Car("name2", 0)
        );
        Cars cars = Cars.of(carList);

        // when
        cars.moveBy(new MoveStrategy() {
            @Override
            public boolean canGo() {
                return true;
            }
        });

        // then
        assertAll(
                () -> assertThat(cars.getCars().get(0).getPosition()).isEqualTo(new CarPosition(1)),
                () -> assertThat(cars.getCars().get(1).getPosition()).isEqualTo(new CarPosition(1)),
                () -> assertThat(cars.getCars().get(2).getPosition()).isEqualTo(new CarPosition(1))
        );
    }

    @DisplayName("자동차가 조건에 따라 전진하지 않는다.")
    @Test
    void 자동차가_조건에따라_전진하지_않는다() {
        // given
        List<Car> carList = List.of(
                new Car("name1", 0),
                new Car("name2", 0),
                new Car("name2", 0)
        );
        Cars cars = Cars.of(carList);

        // when
        cars.moveBy(new MoveStrategy() {
            @Override
            public boolean canGo() {
                return false;
            }
        });

        // then
        assertAll(
                () -> assertThat(cars.getCars().get(0).getPosition()).isEqualTo(new CarPosition(0)),
                () -> assertThat(cars.getCars().get(1).getPosition()).isEqualTo(new CarPosition(0)),
                () -> assertThat(cars.getCars().get(2).getPosition()).isEqualTo(new CarPosition(0))
        );
    }
}