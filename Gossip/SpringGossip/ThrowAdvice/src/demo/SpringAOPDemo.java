package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cuhk.cse.*;

// http://openhome.cc/Gossip/SpringGossip/BeforeAdvice.html
public class SpringAOPDemo {
	public static void main(String[] args){
		ApplicationContext context = new FileSystemXmlApplicationContext("beans-config.xml");
		
		IHandsome handsomeProxy = (IHandsome)context.getBean("handsomeProxy");
		try {
			handsomeProxy.handsome("Chris Wong");
		} catch (Throwable throwable) {
			// ���ε{�����ҥ~�B�z
			System.err.println(throwable);
		}
	}
}
