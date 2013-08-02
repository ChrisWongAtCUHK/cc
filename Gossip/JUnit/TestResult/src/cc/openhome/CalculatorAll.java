package cc.openhome;

public class CalculatorAll {
	public static Test suite() {
		TestSuite<Test> suite = new TestSuite<Test>();

		suite.add(CalculatorPlusMinusTest.suite());
		suite.add(new CalculatorTest("testPlus"));
		return suite;
	}

	// http://openhome.cc/Gossip/JUnit/TestTemplate.html
	public static void main(String[] args) {
		TextTestRunner.run(suite());
		TextTestRunner.run(CalculatorTest.class);
	}
	
}
