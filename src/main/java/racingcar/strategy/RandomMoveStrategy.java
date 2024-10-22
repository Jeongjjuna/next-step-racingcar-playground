package racingcar.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final Random random = new Random();

    @Override
    public boolean canGo() {
        return 4 <= random.nextInt(0, 10);
    }
}
