package racingcar.validation;

import racingcar.constants.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class InputValidation {
    private static final int MAXIMUM_NAME_SIZE = 5;
    private static final int MINIMUM_NAME_SIZE = 1;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String NONE = "";

    public static List<String> validateCarNames(String names) {
        names = names.replace(SPACE, NONE);
        isExist(names);
        List<String> carNames = toList(names);
        areAllNamesMoreThanFive(carNames);
        return carNames;
    }

    public static Integer validateTryCount(String tryCount) {
        isExist(tryCount);
        return toNumber(tryCount);
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
        if (checkBetween1And5(checkSize)) {
            ExceptionMessage.NOT_INPUT_NAME_BETWEEN_1AND5.throwException();
        }
    }

    private static boolean checkBetween1And5(int checkSize) {
        return MINIMUM_NAME_SIZE <= checkSize && checkSize < MAXIMUM_NAME_SIZE;
    }

    private static Integer toNumber(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException numberFormatException) {
            ExceptionMessage.NOT_INPUT_NUMBER.throwException();
        }

        return null;
    }
}
