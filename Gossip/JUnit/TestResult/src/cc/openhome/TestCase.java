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
	public void runTest(TestResult result){
		result.run(this);
	}
	
	public void run() {
		setUp();
		runTest();
		tearDown();
		
	}
	
	public void runTest() {
        Method runMethod= null;
        try {
            runMethod= getClass().getMethod(fName, (Class<?>[])null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!Modifier.isPublic(runMethod.getModifiers())) {
            throw new RuntimeException("method \"" + fName + "\" must be public");
        }
        try {
        	// all exceptions occurring in invoke would be wrapped in InvocationTargetException
            runMethod.invoke(this, (Object [])new Class[0]);
        } catch(InvocationTargetException e){
        	// only target exceptions caught by InvocationTargetException is the real error message 
        	throw new RuntimeException(this.getClass() + "." + runMethod.getName() + ": "+ e.getTargetException().getMessage());
        	
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
