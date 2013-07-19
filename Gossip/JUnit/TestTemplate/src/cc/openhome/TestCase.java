package cc.openhome;

import java.lang.reflect.*;

public class TestCase extends Assert implements Test {
	private String fName;

    public TestCase() {}
    public TestCase(String name) {
        fName = name;
    }
   
    protected void setUp() {}
    protected void tearDown() {}
    
	@Override
	public void run() {
		setUp();
		runTest();
		tearDown();
		
	}
	
	public void runTest() {
        Method runMethod= null;
        try {
            runMethod= getClass().getMethod(fName, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!Modifier.isPublic(runMethod.getModifiers())) {
            throw new RuntimeException("方法 \"" + fName + "\" 必須是 public");
        }
        try {
            runMethod.invoke(this, new Class[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
   
    public String getName() {
        return fName;
    }
   
    public void setName(String name) {
        fName = name;
    }
}
