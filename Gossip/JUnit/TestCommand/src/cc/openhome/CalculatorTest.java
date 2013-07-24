package cc.openhome;

// http://openhome.cc/Gossip/JUnit/TestCommand.html
public class CalculatorTest {
	public static void main(String[] args) {
		TestRunner runner = new TestRunner();
		runner.add(new CalculatorPlusTest());
		runner.add(new CalculatorMinusTest());
		runner.add(new CalculatorMultiplyTest());
		runner.add(new CalculatorDivideTest());
		runner.run();
    }
}
