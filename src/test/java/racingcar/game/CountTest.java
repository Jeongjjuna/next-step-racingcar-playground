package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("[Count] 단위테스트")
class CountTest {

    @DisplayName("카운트를 하나 감소시킬 수 있다.")
    @Test
    void down() {
        // given
        Count count = new Count(10);

        // when
        Count downCount = count.down();

        // then
        assertThat(downCount).isEqualTo(new Count(9));
    }

    @DisplayName("카운트가 남아있는지 알 수 있다.")
    @Test
    void 카운트가_남아있는지_알수있다() {
        // given
        Count count = new Count(10);

        // when
        boolean isRemain = count.isRemain();

        // then
        assertThat(isRemain).isTrue();
    }

    @DisplayName("카운트가 다 소진되었는지 알 수 있다.")
    @Test
    void 카운트가_소진되었는지_알수있다() {
        // given
        Count count = new Count(0);

        // when
        boolean isRemain = count.isRemain();

        // then
        assertThat(isRemain).isFalse();
    }
}