package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startRacingGame() {
        Cars cars = initRacingCarNames();
    }

    private Cars initRacingCarNames() {
        List<String> carNames = inputView.readRacingCarNames();
        return initCars(carNames);
    }

    private Cars initCars(List<String> carNames) {
        Cars cars = new Cars();
        for (String name : carNames) {
            cars.addCar(new Car(name));
        }

        return cars;
    }
}
