package cuhk.cse;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogInterceptor implements MethodInterceptor {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		log("method starts..." + methodInvocation.getMethod());
		
		Object result = null;
		try{
			result = methodInvocation.proceed();
		} finally {
			log("method ends..." + methodInvocation.getMethod() + "\n");
		}
		
		return result;
	}

	private void log(String msg){
		logger.log(Level.INFO, msg);
	}
}
