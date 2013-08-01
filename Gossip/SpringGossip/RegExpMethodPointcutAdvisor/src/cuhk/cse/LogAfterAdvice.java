package cuhk.cse;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class LogAfterAdvice implements AfterReturningAdvice {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args,
			Object target) throws Throwable {
		log("methods ends..." + method);
	}
	
	private void log(String msg){
		logger.log(Level.INFO, msg);
	}
}
