package cuhk.cse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HandsomeCS implements ApplicationContextAware {

	private IHandsome handsomeProxy;
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.handsomeProxy = (IHandsome)context.getBean("handsomeProxy");
	}
	
	public void handsomeCSers(){
		this.handsomeProxy.handsomeBoy("Hoover");
		this.handsomeProxy.handsomeBoy("Leo");
		this.handsomeProxy.handsomeGirl("Cherry");
		this.handsomeProxy.handsome("Chris Wong");
	}

}
