package cc.openhome;

import java.lang.reflect.*;
import java.util.*;

public class TestSuite implements Test {
	private List<Test> tests = new ArrayList<Test>();
	
	public TestSuite(){}
	
	public TestSuite(Class clz){
		// Find every methods start with "test" in name
		Method[] methods = clz.getDeclaredMethods();
		for(Method method: methods){
			if(Modifier.isPublic(method.getModifiers()) && method.getName().startsWith("test")){
				Constructor constructor = null;
				try {
					constructor = clz.getConstructor();
					
					// Instantiate TestCase
					TestCase testCase = (TestCase)constructor.newInstance();
					
					// Set the method to invoke testXXX()
					testCase.setName(method.getName());

					// Add test
					add(testCase);
					
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	

	@Override
	public void run() {
		for(Test test: tests){
			test.run();
			
		}
		
	}
	
	public void add(Test test){
		tests.add(test);
	}

}
