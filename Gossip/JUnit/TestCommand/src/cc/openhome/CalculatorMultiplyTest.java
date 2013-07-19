package cc.openhome;

import cc.openhome.Calculator;

public class CalculatorMultiplyTest implements Test {
	
	@Override
	public void run() {
		Calculator calculator = new Calculator();
		int expected = 2;
		int result = calculator.multiply(1, 2);
		Assert.assertEquals(expected, result);
	}

}
