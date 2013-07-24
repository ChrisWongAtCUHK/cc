package cuhk.cse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// http://openhome.cc/Gossip/SpringGossip/CustomEditorConfigurer.html
public class SpringDemo {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"beans-config.xml");

		ChrisBean chris = (ChrisBean) context.getBean("chrisBean");
		showBean(chris);
		
		System.out.println();
		
		ChrisBean amby = (ChrisBean) context.getBean("ambyBean");
		showBean(amby);

		
	}
	
	public static void showBean(ChrisBean chris){
		try {
			Method[] methods = chris.getClass().getDeclaredMethods();
			
			for(Method method: methods){
				try {

					try {
						if(method.getGenericParameterTypes().length == 0){
							if(method.getGenericReturnType().toString().equals("class java.lang.String")){
								System.out.println(method.invoke(chris));
							} else if(method.getGenericReturnType().toString().equals("class cuhk.cse.Student")){
								Student student = (Student)method.invoke(chris);
								if(student != null){
									System.out.println(student.getName());
									System.out.println(student.getNumber());
								}
							}
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} 
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}		
	}
}
