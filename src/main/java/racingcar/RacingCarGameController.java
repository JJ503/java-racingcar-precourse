package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGameController {
    private static final String COMMA = ",";

    InputView inputView = new InputView();

    public void startGame() {
        List<Car> cars = initCars();
    }

    private List<Car> initCars() {
        List<Car> cars = new ArrayList<>();

        for (String carName : inputCarNames()) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private List<String> inputCarNames() {
       return splitCarNames(inputView.readCarNames());
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(COMMA));
    }
}
