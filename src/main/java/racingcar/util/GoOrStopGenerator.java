package racingcar.util;

import racingcar.constants.MovementState;

@FunctionalInterface
public interface GoOrStopGenerator {
    MovementState generate();
}
