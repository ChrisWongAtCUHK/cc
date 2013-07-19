package cc.openhome;

import cc.openhome.Calculator;

public class CalculatorPlusMinusTest extends TestCase {
	public CalculatorPlusMinusTest(String name) {
        super(name);
    }
   
    public void testPlus() {
        Calculator calculator = new Calculator();
        int expected = 5;
        int result = calculator.plus(3, 2);
        assertEquals(expected, result);
    }
   
    public void testMinus() {
        Calculator calculator = new Calculator();
        int expected = 1;
        int result = calculator.minus(3, 2);
        assertEquals(expected, result);
    }
   
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.add(new CalculatorPlusMinusTest("testPlus"));
        suite.add(new CalculatorPlusMinusTest("testMinus"));
        return suite;
    }
    
    // http://openhome.cc/Gossip/JUnit/TestTemplate.html
    public static void main(String[] args) {
        TestRunner.run(suite());
    }
}
