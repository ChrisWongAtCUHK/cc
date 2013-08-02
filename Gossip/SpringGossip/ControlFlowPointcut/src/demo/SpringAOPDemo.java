package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cuhk.cse.*;

// http://openhome.cc/Gossip/SpringGossip/ControlFlowPointcut.html
public class SpringAOPDemo {
	public static void main(String[] args){
		ApplicationContext context = new FileSystemXmlApplicationContext("beans-config.xml");
		
		HandsomeCS handsomeCS = (HandsomeCS)context.getBean("handsomeCS");
		if(args.length == 1 && "run".equals(args[0])){
			handsomeCS.handsomeCSers();
		} else{
			System.out.println("???");
		}
	}
}
