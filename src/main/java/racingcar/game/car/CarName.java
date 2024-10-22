package racingcar.game.car;

import racingcar.exception.BaseException;

import java.util.Objects;

/**
 * Value Object
 */
public class CarName {

    public static final int MAX_NAME_SIZE = 5;

    private final String name;

    public CarName(String name) {
        validateSize(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateSize(String name) {
        if (MAX_NAME_SIZE < name.length()) {
            throw new BaseException(String.format("[ERROR] 자동차 이름은 최대 %d자까지 가능합니다.", MAX_NAME_SIZE));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }

}
