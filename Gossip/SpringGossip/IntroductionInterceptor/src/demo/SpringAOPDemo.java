package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cuhk.cse.*;

public class SpringAOPDemo {
	
	// http://openhome.cc/Gossip/SpringGossip/IntroductionInterceptor.html
	public static void main(String[] args) {
		 ApplicationContext context = new FileSystemXmlApplicationContext("beans-config.xml"); 
		 Student chris = (Student)context.getBean("proxyFactoryBean");
		 
		 chris.setName("chris");
		 chris.doAssignment();
		 
		 // It is as though student dynamically add method
		 // TODO: why setName do nothing?
		 ((GraduateStudent)chris).setName("chris");
		 ((GraduateStudent)chris).doProject();
		 
	}
}
