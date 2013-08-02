package cc.openhome;

public class Assert {
	public static void assertEquals(String message, int expected, int result) {
        if(expected != result) {
        	if(message == null){
        		throw new RuntimeException(String.format("Fail, expected is %d, but the return value is %d", expected, result));
        	}
        	
        	throw new RuntimeException(String.format(message, expected, result));
        } 
    }
	
	public static void assertEquals(int expected, int result){
		assertEquals(null, expected, result);
	}
}
