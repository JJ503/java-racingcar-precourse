package racingcar.constants;

public enum MovementState {
    GO(1),
    STOP(0);

    private final int movement;

    MovementState(int movement) {
        this.movement = movement;
    }
}
