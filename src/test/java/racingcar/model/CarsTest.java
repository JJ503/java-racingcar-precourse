package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constants.MovementState;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {
    private static final MovementState go = MovementState.GO;
    private static final MovementState stop = MovementState.STOP;
    private Cars cars = new Cars();

    @BeforeEach
    void initCars() {
        List<List<Object>> carInfos = Arrays.asList(
                Arrays.asList("pobi", Arrays.asList(go, go, go, go)),
                Arrays.asList("woni", Arrays.asList(go, stop, go, stop)),
                Arrays.asList("jun", Arrays.asList(stop, stop, go, stop)),
                Arrays.asList("jamie", Arrays.asList(stop, stop, stop, stop))
        );

        for (List<Object> carInfo : carInfos) {
            Car car = new Car((String) carInfo.get(0));
            for (MovementState movementState : (List<MovementState>) carInfo.get(1)) {
                car.addPosition(movementState);
            }
            cars.addCar(car);
        }
    }

    @DisplayName("시도 결과 가져오기 테스트")
    @Test
    void getResultTest() {
        List<List<Object>> expectResult = Arrays.asList(
                Arrays.asList("pobi", 4),
                Arrays.asList("woni", 2),
                Arrays.asList("jun", 1),
                Arrays.asList("jamie", 0)
        );

        assertThat(cars.getResult()).isEqualTo(expectResult);
    }

    @DisplayName("최종 우승자 이름 가져오기 - 한 명인 경우")
    @Test
    void getWinnerOnlyOneTest() {
        List<String> expectResult = Arrays.asList("pobi");

        assertThat(cars.getWinner()).isEqualTo(expectResult);
    }

    @DisplayName("최종 우승자 이름 가져오기 - 두 명인 경우")
    @Test
    void getWinnerTwoTest() {
        Car car = new Car("test");
        List<MovementState> movementStates = Arrays.asList(go, go, go, go);
        for (MovementState movementState : movementStates) {
            car.addPosition(movementState);
        }
        cars.addCar(car);

        List<String> expectResult = Arrays.asList("pobi", "test");

        assertThat(cars.getWinner()).isEqualTo(expectResult);
    }
}
