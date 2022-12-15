package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputValidationTest {

    @DisplayName("자동차 이름 입력 결과 테스트 - 정상 데이터 입력")
    @ValueSource(strings = {"pobi,woni,jun", "pobi, woni, jun", "pobi,woni, jun", "pobi,woni,jun,"})
    @ParameterizedTest
    void validateNormalCarNamesTest(String name) {
        List<String> expectResult = Arrays.asList("pobi", "woni", "jun");
        assertThat(InputValidation.validateCarNames(name)).isEqualTo(expectResult);
    }

    @DisplayName("자동차 이름 입력 결과 테스트 - 비정상 데이터 입력")
    @ValueSource(strings = {"pobi,woni,junnnnnnn", "", "     "})
    @ParameterizedTest
    void validateExceptionCarNamesTest(String name) {
        assertThatThrownBy(() -> InputValidation.validateCarNames(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수 입력 결과 테스트 - 정상 데이터 입력")
    @CsvSource(value = {"5:5", "10:10", "15:15", "20:20"}, delimiter = ':')
    @ParameterizedTest
    void validateNormalTryCountTest(String tryCount, int expectResult) {
        assertThat(InputValidation.validateTryCount(tryCount)).isEqualTo(expectResult);
    }

    @DisplayName("시도 횟수 입력 결과 테스트 - 비정상 데이터 입력")
    @ValueSource(strings = {"", "     ", "2147483648", "sdf123", "sdfsdf"})
    @ParameterizedTest
    void validateExceptionTryCountTest(String tryCount) {
        assertThatThrownBy(() -> InputValidation.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
