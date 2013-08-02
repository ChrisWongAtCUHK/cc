package cc.openhome;

public class TestRunner {

    public static TestResult run(Test test) {
    	TestResult result = new TestResult();
    	test.runTest(result);
    	return result;
    }
    
    public static <T> TestResult run(Class<T> clz){
    	return run(new TestSuite<T>(clz));
    }
}
