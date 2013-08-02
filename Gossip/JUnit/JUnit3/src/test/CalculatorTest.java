package test;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import cuhk.cse.Calculator;

public class CalculatorTest extends TestCase{
	private Calculator calculator;
	
	@Override
	protected void setUp(){
		this.calculator = new Calculator();
	}
	
	@Override
	protected void tearDown(){
		this.calculator = null;
	}
	
	public void testFibNum(){

		int expected[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
		for(int i = 0; i < expected.length; i++){
			int actual = this.calculator.fibNum(i);
			assertEquals(expected[i], actual);
		}
	}
	
	// http://openhome.cc/Gossip/JUnit/JUnit3.html
	/*
	 * TestRunner can be ignored in IDE and  can be called by 
	 * "%JAVA_1_7%\java" -cp ..\junit-4.11.jar;bin junit.textui.TestRunner test.CalculatorTest
	 *  in console
	 */
	/*public static void main(String[] args){
		TestRunner.run(CalculatorTest.class);
	}*/
}
