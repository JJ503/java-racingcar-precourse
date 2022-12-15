package racingcar.constants;

public enum ExceptionMessage {
    NONE_INPUT("값을 입력해 주시길 바랍니다."),
    INPUT_NAME_MORE_THAN_FIVE("자동차 이름의 길이는 5자 이하만 입력해 주시길 바랍니다."),
    NOT_INPUT_NUMBER("시도 횟수는 숫자여야 한다.");

    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
