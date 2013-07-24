package cuhk.cse;

import java.util.Calendar;
import java.util.Locale;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// http://openhome.cc/Gossip/SpringGossip/MessageResource.html
public class SpringDemo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans-config.xml");

		Object[] arguments = new Object[] { "Chris Wong",
				Calendar.getInstance().getTime() };

		System.out.println(context.getMessage("userLogin", arguments, Locale.US));
		System.out.println(context.getMessage("userLogout", arguments, Locale.US));
		
		System.out.println(context.getMessage("userLogin", arguments, Locale.TAIWAN));
		System.out.println(context.getMessage("userLogout", arguments, Locale.TAIWAN));
	}
}
