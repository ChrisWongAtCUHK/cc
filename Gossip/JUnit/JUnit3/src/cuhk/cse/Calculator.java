package cuhk.cse;

public class Calculator {
	
	// Calculate fibonacci number
	public int fibNum(int n){
		if(n < 0){
			return -1;
		}
		
		if(n == 0){
			return 0;
		}
		
		if(n == 1){
			return 1;
		}
		
		int a = 0;
		int b = 1;
		
		for(int i = 1; i <= n; i++){	//  i:	1,2,3,4,5,6	
			int tmp = b;				//	tmp:1,0,1,1,2,3	
			a = a + b;					//	a:	1,1,2,3,5,8
			b = a - tmp;				//	b:	0,1,1,2,3,5
		}
		
		return a;
	}
	
}
