import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

class SumCalculatorTest {

    private SumCalculator sumCalculator;

    @BeforeEach
    void setUp() {
        sumCalculator = new SumCalculator();
    }

    @ParameterizedTest(name = "Test #{index}: sum({0}) should return {1}")
    @CsvSource({
            "1, 1",
            "3, 6",
    })
    void testSum(int number, int expectedResult) {
        int result = sumCalculator.sum(number);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test @DisplayName("Test that sum throws IllegalArgumentException for zero input")
    void testSumThrowsExceptionForZeroInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> sumCalculator.sum(0));
    }
}
