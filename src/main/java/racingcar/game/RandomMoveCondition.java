package racingcar.game;

import java.util.Random;

public class RandomMoveCondition implements MoveCondition {

    private final Random random = new Random();

    @Override
    public boolean canGo() {
        return 4 <= random.nextInt(0, 10);
    }
}
