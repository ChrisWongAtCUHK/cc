package onlyfun.caterpillar;

import org.springframework.beans.factory.support.BeanDefinitionRegistry; 
import org.springframework.beans.factory.support.DefaultListableBeanFactory; 
import org.springframework.beans.factory.support.RootBeanDefinition; 
import org.springframework.beans.factory.BeanFactory; 
import org.springframework.beans.MutablePropertyValues; 

public class SpringDemo2 {
	public static void main(String[] args) {
		// 設置屬性
		MutablePropertyValues properties = new MutablePropertyValues();
		properties.addPropertyValue("chrisWong", "Chris Wong!Handsome!");

		// 設置Bean定義
		RootBeanDefinition definition = new RootBeanDefinition(ChrisBean.class,
				properties);

		// 註冊Bean定義與Bean別名
		BeanDefinitionRegistry reg = new DefaultListableBeanFactory();
		reg.registerBeanDefinition("chrisBean", definition);

		BeanFactory factory = (BeanFactory) reg;
		ChrisBean hello = (ChrisBean) factory.getBean("chrisBean");
		System.out.println(hello.getChrisWong());
	}
}
