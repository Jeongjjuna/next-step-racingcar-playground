package racingcar.domain.car;

public class Car {

    private final CarName name;

    private CarPosition position;

    public Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(new CarName(name), new CarPosition(0));
    }

    public Car(String name, int position) {
        this(new CarName(name), new CarPosition(position));
    }

    public CarPosition moveForward() {
        position = position.moveForward();
        return position;
    }

    public boolean isIn(CarPosition position) {
        return this.position.equals(position);
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getPosition() {
        return position;
    }

}
