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
        try {
            List<String> carNames = splitCarNames(inputView.readCarNames());
            validateCarNames(carNames);
            return carNames;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputCarNames();
        }
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(COMMA));
    }

    private void validateCarNames(List<String> carNames) {
        isNotEmpty(carNames);

        for (String carName : carNames) {
            isOverFive(carName);
        }
    }

    private void isNotEmpty(List<String> carNames) {
        if (carNames.get(0).isEmpty()) {
            ExceptionMessage.NONE_INPUT_MESSAGE.throwException();
        }
    }

    private void isOverFive(String carName) {
        if (carName.length() > 5) {
            ExceptionMessage.INPUT_NAME_LENGTH_MORE_THAN_FIVE_MESSAGE.throwException();
        }
    }
}
