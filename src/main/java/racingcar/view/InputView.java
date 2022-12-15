package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidation;

import java.util.List;

public class InputView {
    private static final String INPUT_RACING_CAR_NAMES
            = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACING_TRY_COUNT
            = "시도할 회수는 몇회인가요?";

    public List<String> readRacingCarNames() {
        System.out.println(INPUT_RACING_CAR_NAMES);
        try {
            return InputValidation.validateCarNames(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            readRacingCarNames();
        }

        return null;
    }

    public Integer readRacingTryCount() {
        System.out.println(INPUT_RACING_TRY_COUNT);
        try {
            return InputValidation.validateTryCount(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            readRacingTryCount();
        }

        return null;
    }
}
