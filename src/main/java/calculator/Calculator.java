package calculator;

public class Calculator {

	private double currentValue;
	
	public int readCurrentValue() {
		return (int)Math.round(currentValue);
	}

	public void add(double value) {
		currentValue += value;
	}

	public void subtract(double value) {
		currentValue -= value;
	}

	public void multiply(double value) {
		currentValue *= value;
	}

	public void divide(double value) {
		if (value==0) throw new IllegalArgumentException("Cannot divide by zero");
		currentValue /= value;
	}

}