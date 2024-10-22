package racingcar.domain.car;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {

    private final int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public CarPosition moveForward() {
        return new CarPosition(position + 1);
    }

    public int getPosition() {
        return position;
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

    @Override
    public String toString() {
        return String.valueOf(position);
    }

    @Override
    public int compareTo(CarPosition other) {
        return Integer.compare(this.position, other.position);
    }
}
