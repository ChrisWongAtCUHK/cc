package demo;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cuhk.cse.*;

public class SpringAOPDemo {
	
	// http://openhome.cc/Gossip/SpringGossip/DelegatingIntroductionInterceptor.html
	public static void main(String[] args) {
		 ApplicationContext context = new FileSystemXmlApplicationContext("beans-config.xml");
		 Student student = (Student)context.getBean("proxyFactoryBean");
		 
		 // No lock, set method can be invoked
		 student.setName("chris");
		 System.out.println(student.getName());
		 
		 try{
			 // Lock the object
			 ((ILockable)student).lock();
			 
			 // Cannot invoke set method, throw exception
			 student.setName("amby");
			 // The following line cannot be executed because exception is thrown
			 System.out.println(student.getName());
		 } catch(Throwable e){
			 e.printStackTrace();
		 }
		 
		 // Object is unlocked
		 ((ILockable)student).unlock();
		 // It's ok to use setter again.
		 student.setName("amby");
		 System.out.println(student.getName());
	}
}
