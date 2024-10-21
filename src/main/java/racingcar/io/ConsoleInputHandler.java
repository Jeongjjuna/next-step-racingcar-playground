package racingcar.io;

import racingcar.game.Cars;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Cars getPlayCars() {
        return null;
    }
}
