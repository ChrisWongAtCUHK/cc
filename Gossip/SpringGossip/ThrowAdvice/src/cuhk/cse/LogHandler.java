package cuhk.cse;

import java.util.logging.*; 
import java.lang.reflect.*; 

public class LogHandler implements InvocationHandler { 
    private Logger logger = 
            Logger.getLogger(this.getClass().getName()); 
    
    private Object delegate;

    public Object bind(Object delegate) { 
        this.delegate = delegate; 
        return Proxy.newProxyInstance( 
                           delegate.getClass().getClassLoader(), 
                           delegate.getClass().getInterfaces(), 
                           this); 
    } 

    public Object invoke(Object proxy, Method method, 
                         Object[] args) throws Throwable { 
        Object result = null; 
        
        try { 
            log("method starts..." + method);
            
            result = method.invoke(delegate, args);
            
            log("method ends..." + method); 
        } catch (Exception e){ 
            log(e.toString()); 
        }
        
        return result; 
    } 
    
    private void log(String message) {
        logger.log(Level.INFO, message);
    }
}