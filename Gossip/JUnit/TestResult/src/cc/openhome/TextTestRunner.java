package cc.openhome;

public class TextTestRunner {
    public static void run(Test test) {
    	TestResult result = new TestResult();
    	test.runTest(result);
    	for(String message: result.getMessages()){
    		System.out.println(message);
    	}
    	
    }
    
    public static <T> void run(Class<T> clz){
    	run(new TestSuite<T>(clz));
    }
}
