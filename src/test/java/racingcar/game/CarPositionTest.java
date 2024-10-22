package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarPosition;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[CarPosition] 단위테스트")
class CarPositionTest {

    @DisplayName("포지션이 1 증가한다.")
    @Test
    void 포지션이_1증가한다() {
        // given
        CarPosition carPosition = new CarPosition(1);

        // when
        CarPosition afterPosition = carPosition.moveForward();

        // then
        assertThat(afterPosition).isEqualTo(new CarPosition(2));
    }
}