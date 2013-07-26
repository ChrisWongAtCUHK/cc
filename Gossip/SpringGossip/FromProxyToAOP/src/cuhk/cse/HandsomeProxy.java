package cuhk.cse;

import java.util.logging.*;

public class HandsomeProxy implements IHandsome {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private IHandsome handsomeObject;
	
	public HandsomeProxy(IHandsome handsomeObject){
		this.handsomeObject = handsomeObject;
	}
	
	@Override
	public void handsome(String name) {
        // ��x�A��
        log("hello method starts....");      

        // ����Ӱ��޿�
        handsomeObject.handsome(name);
        
        // ��x�A��
        log("hello method ends...."); 		
	}
	
	private void log(String msg){
		logger.log(Level.INFO, msg);
	}
	
}
