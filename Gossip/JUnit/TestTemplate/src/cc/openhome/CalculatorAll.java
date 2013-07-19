package cc.openhome;

public class CalculatorAll {
	public static Test suite() {
		TestSuite suite = new TestSuite();
		// �H�K�A�զX
		suite.add(CalculatorPlusMinusTest.suite());
//		suite.add(CalculatorTest.class);
		suite.add(new CalculatorTest("testPlus"));
		return suite;
	}

	// http://openhome.cc/Gossip/JUnit/TestTemplate.html
	public static void main(String[] args) {
		TestRunner.run(suite());
		TestRunner.run(CalculatorTest.class);
	}
	
}
