package racingcar.game;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("[Car] 단위테스트")
class CarTest {

    @DisplayName("자동차 생성 성공")
    @Test
    void 자동차_생성() {
        // given
        CarName name = new CarName("name");
        CarPosition position = new CarPosition(1);

        // when & then
        assertThatCode(() -> new Car(name, position))
                .doesNotThrowAnyException();
    }

    @DisplayName("자동차가 앞으로한칸 전진")
    @Test
    void 자동차가_앞으로한칸_전진() {
        // given
        Car car = new Car("name", 1);

        // when
        CarPosition afterPosition = car.moveForward();

        // then
        assertThat(afterPosition).isEqualTo(new CarPosition(2));
    }

    @DisplayName("자동차가 특정 위치에 있는지 알 수 있다.")
    @Test
    void 자동차가_특정위치에_있는지_알수있다() {
        // given
        Car car = new Car("name", 3);

        // when
        boolean isSamePosition = car.isIn(new CarPosition(3));
        boolean isDiffPosition = car.isIn(new CarPosition(7));

        // then
        assertThat(isSamePosition).isTrue();
        assertThat(isDiffPosition).isFalse();
    }

    @DisplayName("자동차의 이름을 알 수 있다.")
    @Test
    void 자동차의_이름을_알수있다() {
        // given
        Car car = new Car("name", 3);

        // when
        CarName carName = car.getName();

        // then
        assertThat(carName).isEqualTo(new CarName("name"));
    }

    @DisplayName("자동차의 위치를 알 수 있다.")
    @Test
    void 자동차의_위치를_알수있다() {
        // given
        Car car = new Car("name", 3);

        // when
        CarPosition carPosition = car.getPosition();

        // then
        assertThat(carPosition).isEqualTo(new CarPosition(3));
    }

}