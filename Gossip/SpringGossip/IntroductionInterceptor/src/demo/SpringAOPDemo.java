package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cuhk.cse.*;

public class SpringAOPDemo {
	
	// http://openhome.cc/Gossip/SpringGossip/IntroductionInterceptor.html
	public static void main(String[] args) {
		 ApplicationContext context = new FileSystemXmlApplicationContext("beans-config.xml"); 
		 Student ken = (Student)context.getBean("proxyFactoryBean");
		 
		 ken.setName("ken");
		 ken.doAssignment();
		 
		 // It is as though studnet dynamically add method
		 ((GraduateStudent)ken).doProject();
		 
	}
}
