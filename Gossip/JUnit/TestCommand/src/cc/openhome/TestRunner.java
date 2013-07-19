package cc.openhome;
import java.util.*;

public class TestRunner {
    private List<Test> tests;
    public TestRunner() {
        tests = new ArrayList<Test>();
    }
    public void add(Test test) {
        tests.add(test);
    }
    public void run() {
        for(Test test : tests) {
            test.run();
        }
    }
}
