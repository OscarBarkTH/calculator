package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCalculator {
	
    private Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new Calculator();
    }

    @Test
    public void readCurrentValue_CalculatorIsCreated_ValueIsZero() {
        // Assert
        assertEquals(0, calculator.readCurrentValue());
    }

    @Test
    public void add_AddSingleValue_ValueIsAdded() {
        // Act
        calculator.add(5);

        // Assert
        assertEquals(5, calculator.readCurrentValue());
    }

    @Test
    public void add_AddSingleDecimalValue_ValueIsAddedAndReturnedValueIsRoundedUp() {
        // Act
        calculator.add(5.5);

        // Assert
        assertEquals(6, calculator.readCurrentValue());
    }

    @Test
    public void add_AddMultipleValues_ValuesAreSummedTogether() {
        // Act
        calculator.add(1);
        calculator.add(1.5);
        calculator.add(2);
        calculator.add(2.5);
        calculator.add(3);
        calculator.add(3.5);

        // Assert
        assertEquals(14, calculator.readCurrentValue());
    }

    @Test
    public void add_AddNegativeValue_ValueIsSubtracted() {
        // Arrange
        calculator.add(10);

        // Act
        calculator.add(-4);

        // Assert
        assertEquals(6, calculator.readCurrentValue());
    }

    @Test
    public void subtract_SubtractIntegerValue_ValueIsSubtracted() {
        // Act
        calculator.subtract(10);

        // Assert
        assertEquals(-10, calculator.readCurrentValue());
    }

    @Test
    public void subtract_SubtractDecimalValue_ValueIsSubtractedAndReturnedValueIsRoundedUp() {
        // Act
        calculator.subtract(2.3);

        // Assert
        assertEquals(-2, calculator.readCurrentValue());
    }

    @Test
    public void multiply_MultiplyWhenCurrentValueIsZero_ValueRemainsZero() {
        // Act
        calculator.multiply(10);

        // Assert
        assertEquals(0, calculator.readCurrentValue());
    }

    @Test
    public void multiply_MultiplyWhenCurrentValueIsOne_ValueIsReturned() {
        // Arrange
        calculator.add(1);

        // Act
        calculator.multiply(10);

        // Assert
        assertEquals(10, calculator.readCurrentValue());
    }

    @Test
    public void multiply_MultiplyByFive_ValueTimesFiveIsReturned() {
        // Arrange
        calculator.add(6);

        // Act
        calculator.multiply(5);

        // Assert
        assertEquals(30, calculator.readCurrentValue());
    }

    @Test
    public void multiply_MultiplyByNegativeValue_NegativeValueIsReturned() {
        // Arrange
        calculator.add(6);

        // Act
        calculator.multiply(-5);

        // Assert
        assertEquals(-30, calculator.readCurrentValue());
    }

    @Test
    public void multiply_MultiplySeveralTimes_ValuesAreMultiplied() {
        // Arrange
        calculator.add(1);

        // Act
        calculator.multiply(-2);  // 1 * -2 = -2
        calculator.multiply(3);  // -2 * 3 = -6
        calculator.multiply(-4);  // -6 * -4 = 24
        calculator.multiply(5);  // 24 * 5 = 120

        // Assert
        assertEquals(120, calculator.readCurrentValue());
    }

    @Test
    public void divide_DivideByOne_ValuesIsUnchanged() {
        // Arrange
        calculator.add(10);

        // Act
        calculator.divide(1);

        // Assert
        assertEquals(10, calculator.readCurrentValue());
    }

    @Test
    public void divide_DivideByTwo_ValueIsHalved() {
        // Arrange
        calculator.add(10);

        // Act
        calculator.divide(2);

        // Assert
        assertEquals(5, calculator.readCurrentValue());
    }

    @Test
    public void divide_DivideByTwoWhenValueIsOdd_ValueIsHalvedAndRoundedUp() {
        // Arrange
        calculator.add(11);

        // Act
        calculator.divide(2);

        // Assert
        assertEquals(6, calculator.readCurrentValue());
    }

    @Test
    public void divide_DivideByZero_ThrowsInvalidArgumentException() {
        // Act & assert
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(0));
    }

    @Test
    public void combination_UseMultipleOperations_ValueIsCalculated() {
        // Act
        calculator.add(5);
        calculator.multiply(3);  // 5 * 3 = 15
        calculator.divide(-5);  // 15 / -5 = -3
        calculator.subtract(7);  // -3 - 7 = -10

        // Assert
        assertEquals(-10, calculator.readCurrentValue());
    }

    @Test
    public void combination_UseMultipleOperations2_ValueIsCalculated() {
        // Act
        calculator.divide(10);  // 0 / 10 = 0
        calculator.subtract(5.5);  // 0 - 5.5 = -5.5
        calculator.multiply(3);  // -5.5 * 3 = -16.5

        // Assert
        assertEquals(-16, calculator.readCurrentValue());  // -16.5 rounded up = -16
    }
}