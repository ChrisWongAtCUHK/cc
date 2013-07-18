package onlyfun.caterpillar; 

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader; 
//import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

// http://openhome.cc/Gossip/SpringGossip/BeanDefWithoutXML.html
public class SpringDemo1 { 
    public static void main(String[] args) { 
        BeanDefinitionRegistry reg = 
            new DefaultListableBeanFactory(); 
        PropertiesBeanDefinitionReader reader = 
            new PropertiesBeanDefinitionReader(reg); 
        reader.loadBeanDefinitions(
                new FileSystemResource("beans-config.properties")); 
        
        BeanFactory factory = (BeanFactory) reg; 
        ChrisBean hello = (ChrisBean) factory.getBean("chrisBean"); 
        System.out.println(hello.getChrisWong()); 
    } 
}