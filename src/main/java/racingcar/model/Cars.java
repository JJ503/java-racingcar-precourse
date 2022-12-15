package racingcar.model;

import racingcar.util.GoOrStopValueGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<List<Object>> getResult() {
        List<List<Object>> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.getCarInformation());
        }

        return result;
    }

    public List<String> getWinner() {
        if (cars.size() == ONE) {
            return cars.stream()
                    .map(Car::getName)
                    .collect(Collectors.toList());
        }

        int winningPosition = sortedCarByPosition().get(0).getPosition();
        return getSamePositionCars(winningPosition);
    }

    private List<Car> sortedCarByPosition() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getPosition).reversed())
                .collect(Collectors.toList());
    }

    private List<String> getSamePositionCars(int winningPosition) {
        return cars.stream()
                .filter(car -> car.isEqualPosition(winningPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
