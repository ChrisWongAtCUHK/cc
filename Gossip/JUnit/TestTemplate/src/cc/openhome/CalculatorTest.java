package cc.openhome;

import cc.openhome.Calculator;

public class CalculatorTest extends TestCase {
	private Calculator calculator;
	public CalculatorTest() {}  
    public CalculatorTest(String name) {
        super(name);
    }
    
    @Override
    protected void setUp() {
        calculator = new Calculator();
    }
    
    @Override
    protected void tearDown() {
        calculator = null;
    }
    
    public void testPlus() {
        int expected = 5;
        int result = calculator.plus(3, 2);
        assertEquals(expected, result);
    }
   
    public void testMinus() {
        int expected = 1;
        int result = calculator.minus(3, 2);
        assertEquals(expected, result);
    }
    
    public void testMulitply(){
		int expected = 8;
		int result = calculator.multiply(4, 2);
		Assert.assertEquals(expected, result);	
    }
    
    // http://openhome.cc/Gossip/JUnit/TestTemplate.html
	public static void main(String[] args){
		TestRunner.run(CalculatorTest.class);
	}

}
