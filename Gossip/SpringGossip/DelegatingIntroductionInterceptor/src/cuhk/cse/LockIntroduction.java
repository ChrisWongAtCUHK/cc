package cuhk.cse;

import org.springframework.aop.support.DelegatingIntroductionInterceptor; 
import org.aopalliance.intercept.MethodInvocation; 
import org.springframework.aop.framework.AopConfigException;

public class LockIntroduction extends DelegatingIntroductionInterceptor implements ILockable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean locked;
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// If locked is true, set method cannot be invoked
		if(isLocked() && invocation.getMethod().getName().indexOf("set") == 0){
			throw new AopConfigException("Object is locked!!");
		}
		return super.invoke(invocation);
	}
	
	@Override
	public void lock() {
		this.locked = true;
	}

	@Override
	public void unlock() {
		this.locked = false;
		
	}

	@Override
	public boolean isLocked() {
		return locked;
	}

}
