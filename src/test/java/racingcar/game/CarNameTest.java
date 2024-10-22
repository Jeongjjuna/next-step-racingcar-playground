package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.BaseException;
import racingcar.domain.car.CarName;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("[CarName] 단위테스트")
class CarNameTest {

    @DisplayName("차동차 이름 길이길면 예외발생")
    @Test
    void 자동차_이름생성시_이름이길면_예외발생() {
        // given
        String invalidName = "A".repeat(CarName.MAX_NAME_SIZE + 1);

        // when & then
        assertThrows(BaseException.class, () -> new CarName(invalidName));
    }

    @DisplayName("자동차 이름 생성 성공")
    @Test
    void 자동차_이름_생성() {
        // given
        String invalidName = "ABCDE";

        // when & then
        assertThatCode(() -> new CarName(invalidName))
                .doesNotThrowAnyException();
    }
}