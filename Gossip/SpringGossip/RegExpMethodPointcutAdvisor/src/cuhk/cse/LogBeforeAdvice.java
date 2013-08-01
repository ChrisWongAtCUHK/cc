package cuhk.cse;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		log("method starts..." + method);
		
	}
	
	private void log(String msg){
		logger.log(Level.INFO, msg);
	}

}
