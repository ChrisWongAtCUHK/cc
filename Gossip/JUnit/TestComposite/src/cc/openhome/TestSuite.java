package cc.openhome;

import java.util.*;

public class TestSuite implements Test {
	private List<Test> tests;
	
	public TestSuite(){
		tests = new ArrayList<Test>();
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
