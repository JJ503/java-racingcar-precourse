package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.MovementState;

public class GoOrStopValueGenerator implements GoOrStopGenerator {
    private static final int RANDOM_START_NUMBER = 0;
    private static final int RANDOM_END_NUMBER = 9;

    @Override
    public MovementState generate() {
        return MovementState.getMovementState(
                Randoms.pickNumberInRange(RANDOM_START_NUMBER,RANDOM_END_NUMBER)
        );
    }
}
