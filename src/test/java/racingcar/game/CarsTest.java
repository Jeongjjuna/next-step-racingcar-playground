package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        Cars cars = new Cars(carList);

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
        Cars cars = new Cars(carList);

        // when
        List<Car> findCars = cars.getCars();

        // then
        assertThat(findCars.size()).isEqualTo(3);
    }
}