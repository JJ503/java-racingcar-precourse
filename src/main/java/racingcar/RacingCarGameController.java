package racingcar;

public class RacingCarGameController {
    InputView inputView = new InputView();

    public void startGame() {
        System.out.println(inputCarNames());
    }

    private String inputCarNames() {
        return inputView.readCarNames();
    }
}
