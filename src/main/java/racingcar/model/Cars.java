package racingcar.model;

import racingcar.util.GoOrStopValueGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int ONE = 1;
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void tryRacingOnce() {
        for (Car car : cars) {
            car.addPosition(new GoOrStopValueGenerator().generate());
        }
    }
}
