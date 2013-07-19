package cc.openhome;

public class CalculatorDivideTest implements Test {

	@Override
	public void run() {
		Calculator calculator = new Calculator();
		int expected = 2;
		int result = calculator.divide(4, 2);
		Assert.assertEquals(expected, result);	
	}

}
