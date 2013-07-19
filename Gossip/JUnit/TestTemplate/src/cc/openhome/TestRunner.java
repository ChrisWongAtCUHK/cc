package cc.openhome;
import java.util.*;

public class TestRunner {

    public static void run(Test test) {
        test.run();
    }
    
    public static void run(Class clz){
    	run(new TestSuite(clz));
    }
}
