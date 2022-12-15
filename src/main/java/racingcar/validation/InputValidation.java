package racingcar.validation;

import racingcar.constants.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class InputValidation {
    private static final String COMMA = ",";

    public static List<String> validateCarNames(String names) {
        isExist(names);
        List<String> carNames = toList(names);
        areAllNamesMoreThanFive(carNames);
        return carNames;
    }

    private static void isExist(String checkValue) {
        if (checkValue.isEmpty()) {
            ExceptionMessage.NONE_INPUT.throwException();
        }
    }

    private static List<String> toList(String names) {
        return Arrays.asList(names.split(COMMA));
    }

    private static void areAllNamesMoreThanFive(List<String> carNames) {
        for (String name : carNames) {
            isMoreThanFive(name.length());
        }
    }

    private static void isMoreThanFive(int checkSize) {
        if (checkSize > 5) {
            ExceptionMessage.INPUT_NAME_MORE_THAN_FIVE.throwException();
        }
    }
}
