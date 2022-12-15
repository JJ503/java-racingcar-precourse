package racingcar.validation;

import racingcar.constants.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class InputValidation {
    private static final String COMMA = ",";

    public List<String> validateCarNames(String names) {
        isExist(names);
        List<String> carNames = toList(names);
        areAllNamesMoreThanFive(carNames);
        return carNames;
    }

    private void isExist(String checkValue) {
        if (checkValue.isEmpty()) {
            ExceptionMessage.NONE_INPUT.throwException();
        }
    }

    private List<String> toList(String names) {
        return Arrays.asList(names.split(COMMA));
    }

    private void areAllNamesMoreThanFive(List<String> carNames) {
        for (String name : carNames) {
            isMoreThanFive(name.length());
        }
    }

    private void isMoreThanFive(int checkSize) {
        if (checkSize > 5) {
            ExceptionMessage.INPUT_NAME_MORE_THAN_FIVE.throwException();
        }
    }
}
