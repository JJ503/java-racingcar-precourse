package racingcar.model;

import racingcar.constants.MovementState;
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void addPosition(MovementState movementState) {
        position += movementState.getMovement();
    }
}
