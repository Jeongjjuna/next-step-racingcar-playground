package racingcar.game;

import java.util.Objects;

public class Count {

    private final int count;

    public Count(int count) {
        this.count = count;
    }

    public Count down() {
        return new Count(count - 1);
    }

    public boolean isRemain() {
        return 0 < count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count that = (Count) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }

}
