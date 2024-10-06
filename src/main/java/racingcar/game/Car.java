package racingcar.game;

public class Car {

    private final CarName name;

    private CarPosition position;

    public Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public CarPosition moveForward() {
        position = position.moveForward();
        return position;
    }
}
