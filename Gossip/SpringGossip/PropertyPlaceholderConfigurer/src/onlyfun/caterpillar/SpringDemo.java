package onlyfun.caterpillar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// http://openhome.cc/Gossip/SpringGossip/PropertyPlaceholderConfigurer.html
public class SpringDemo {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"beans-config.xml");

		ChrisBean chris = (ChrisBean) context.getBean("chrisBean");

		try {
			Method[] methods = chris.getClass().getDeclaredMethods();
			
			for(Method method: methods){
				try {

					if((method.getGenericReturnType().toString().equals("class java.lang.String")) && (method.getGenericParameterTypes().length == 0)){
						try {
							System.out.println(method.invoke(chris));
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
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
