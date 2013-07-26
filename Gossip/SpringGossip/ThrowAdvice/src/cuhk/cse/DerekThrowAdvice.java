package cuhk.cse;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.aop.ThrowsAdvice;

public class DerekThrowAdvice implements ThrowsAdvice {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void afterThrowing(Method method, Object[] args, Object target, Throwable subclass){
		// °O¿ý¨Ò¥~
		log("Loggin that a " + subclass + "Exception was thrown in " + method);
	}
	
	private void log(String msg){
		logger.log(Level.INFO, msg);
	}
}
