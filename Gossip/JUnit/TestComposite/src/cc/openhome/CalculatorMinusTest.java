package cc.openhome;

import cc.openhome.Calculator;

public class CalculatorMinusTest implements Test {

	@Override
	public void run() {
		Calculator calculator = new Calculator();
		int expected = -1;
		int result = calculator.minus(1, 2);
		Assert.assertEquals(expected, result);
	}

}
