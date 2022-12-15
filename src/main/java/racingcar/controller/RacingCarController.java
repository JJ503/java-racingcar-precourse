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
        int tryCount = initTryCount();
        tryRacingByTryCount(tryCount, cars);
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

    private int initTryCount() {
        return inputView.readRacingTryCount();
    }

    private void tryRacingByTryCount(int tryCount, Cars cars) {
        outputView.printStartGameMessage();

        for (int count = 0; count < tryCount; count++) {
            cars.tryRacingOnce();
            outputView.printTryResult(cars.getResult());
        }

        outputView.printWinners(cars.getWinner());
    }
}
