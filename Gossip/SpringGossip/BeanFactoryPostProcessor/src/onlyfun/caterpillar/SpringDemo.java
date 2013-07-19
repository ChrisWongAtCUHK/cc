package onlyfun.caterpillar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringDemo {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"beans-config.xml");

		ChrisBean chris = (ChrisBean) context.getBean("chrisBean");
		System.out.println(chris.getChrisWong());
		//System.out.println(chris.getAmby());
	}
}
