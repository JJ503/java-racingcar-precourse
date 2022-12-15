package racingcar.constants;

public enum ExceptionMessage {
    NONE_INPUT("값을 입력해 주시길 바랍니다.");

    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
