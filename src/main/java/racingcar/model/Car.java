package racingcar.model;

import racingcar.constants.MovementState;

import java.util.Arrays;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void addPosition(MovementState movementState) {
        position += movementState.getMovement();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public List<Object> getCarInformation() {
        return Arrays.asList(name, position);
    }
}
