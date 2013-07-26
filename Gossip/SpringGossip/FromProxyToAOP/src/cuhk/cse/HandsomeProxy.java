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
        // 日誌服務
        log("hello method starts....");      

        // 執行商務邏輯
        handsomeObject.handsome(name);
        
        // 日誌服務
        log("hello method ends...."); 		
	}
	
	private void log(String msg){
		logger.log(Level.INFO, msg);
	}
	
}
