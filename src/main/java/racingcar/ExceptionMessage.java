package racingcar;

public enum ExceptionMessage {
    NONE_INPUT_MESSAGE("값을 입력해야 한다."),
    INPUT_NAME_LENGTH_MORE_THAN_FIVE_MESSAGE("자동차 이름의 길이는 5 이하여야 한다."),
    INPUT_WRONG_TRY_COUNT_MESSAGE("시도 횟수는 숫자여야 한다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = ERROR_TAG + message + System.lineSeparator();
    }

    public void throwException() {
        throw new IllegalArgumentException(message);
    }
}
