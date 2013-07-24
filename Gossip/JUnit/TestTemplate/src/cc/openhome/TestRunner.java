package cc.openhome;

public class TestRunner {

    public static void run(Test test) {
        test.run();
    }
    
    public static <T> void run(Class<T> clz){
    	run(new TestSuite<T>(clz));
    }
}
