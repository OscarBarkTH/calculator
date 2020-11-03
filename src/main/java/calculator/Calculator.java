package calculator;

/**
 * Calculator is a class representing a simple calculator with simple arithmetic
 * operations. The calculator stores a single floating point value which
 * arithmetic operations are performed on.
 * <p>
 * The stored current value cannot be displayed with floating point precision,
 * but only the closest integer can be displayed.
 * 
 * @author OscarBark
 *
 */
public class Calculator {

	/**
	 * The currently stored value of the calculator
	 */
	private double currentValue;
	
	/**
	 * Returns the current value that the calculator has calculated. The calculator
	 * is only able to display integer values, and if the value is a floating point
	 * number it should be rounded up to the closest integer.
	 * 
	 * @return The current calculated value rounded up to the closest integer.
	 */
	public int readCurrentValue() {
		return (int)Math.round(currentValue);
	}

	/**
	 * Adds the specified value to the current value of the calculator.
	 * 
	 * @param value The value to add
	 */
	public void add(double value) {
		currentValue += value;
	}

	/**
	 * Subtracts the specified value from the current value of the calculator.
	 * 
	 * @param value The value to subtract
	 */
	public void subtract(double value) {
		currentValue -= value;
	}

	/**
	 * Multiplies the current value of the calculator with the specified value.
	 * 
	 * @param value The value to multiply with
	 */
	public void multiply(double value) {
		currentValue *= value;
	}

	/**
	 * Divides the current value of the calculator with the specified value.
	 * 
	 * @param value The value to divide with
	 * @throws IllegalArgumentException If value is zero
	 */
	public void divide(double value) {
		if (value==0) throw new IllegalArgumentException("Cannot divide by zero");
		currentValue /= value;
	}

}