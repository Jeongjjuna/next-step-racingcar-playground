package racingcar.game;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("[CaroTest] 단위테스트")
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
        CarName name = new CarName("name");
        CarPosition position = new CarPosition(1);
        Car car = new Car(name, position);

        // when
        CarPosition afterPosition = car.moveForward();

        // then
        assertThat(afterPosition).isEqualTo(new CarPosition(2));
    }
}