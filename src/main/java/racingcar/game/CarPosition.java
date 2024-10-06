package racingcar.game;

import java.util.Objects;

public class CarPosition {

    private final int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public CarPosition moveForward() {
        return new CarPosition(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }

}
