package onlyfun.caterpillar;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryModifier implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		// TODO Auto-generated method stub
		BeanDefinition bd = beanFactory.getBeanDefinition("chrisBean");  
        MutablePropertyValues pv =  bd.getPropertyValues();  
        System.out.println(pv.getPropertyValueList());
        if(pv.contains("chrisWong")) {  
            pv.addPropertyValue("chrisWong", "=__=");  
        }  
	}

}
