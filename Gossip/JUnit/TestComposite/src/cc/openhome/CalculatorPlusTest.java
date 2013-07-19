package cc.openhome;

import cc.openhome.Calculator;
public class CalculatorPlusTest implements Test {

	@Override
	public void run() {
		Calculator calculator = new Calculator();
		int expected = 3;
		int result = calculator.plus(1, 2);
		Assert.assertEquals(expected, result);
	}

}
