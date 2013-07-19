package cc.openhome;

public class CalculatorTest {

	public static Test plusMinusSuite(){
		TestSuite suite = new TestSuite();
		suite.add(new CalculatorPlusTest());
		suite.add(new CalculatorMinusTest());
		return suite;
	}
	
	public static Test plusMinusMultiyDivideSuite(){
		TestSuite suite = new TestSuite();
		suite.add(new CalculatorPlusTest());
		suite.add(new CalculatorMinusTest());
		suite.add(new CalculatorMultiplyTest());
		suite.add(new CalculatorDivideTest());
		return suite;
	}
	
	public static void main(String[] args){
		TestRunner.run(plusMinusMultiyDivideSuite());
	}
}
