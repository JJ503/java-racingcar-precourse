package racingcar.constants;

public enum MovementState {
    GO(1),
    STOP(0);

    private static int MINIMUM_FOR_MOVEMENT = 4;
    private final int movement;

    MovementState(int movement) {
        this.movement = movement;
    }

    public static MovementState getMovementState(int number) {
        if (MINIMUM_FOR_MOVEMENT <= number) {
            return GO;
        }

        return STOP;
    }
}
