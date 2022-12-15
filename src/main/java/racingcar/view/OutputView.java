package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String START_GAME_MESSAGE = "\n실행 결과";
    private static final String STEP_ICON = "-";
    private static final String TRY_RESULT_FORMAT = "%s : %s\n";
    private static final int NAME_INFORM_INDEX = 0;
    private static final int POSITION_INFORM_INDEX = 1;

    public void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printTryResult(List<List<Object>> resultInformation) {
        for (List<Object> resultCar : resultInformation) {
            System.out.printf(TRY_RESULT_FORMAT, resultCar.get(NAME_INFORM_INDEX),
                    getStepIconByPosition((Integer) resultCar.get(POSITION_INFORM_INDEX)));
        }
        System.out.println();
    }

    private String getStepIconByPosition(int position) {
        return new String(new char[position]).replace("\0", STEP_ICON);
    }
}
