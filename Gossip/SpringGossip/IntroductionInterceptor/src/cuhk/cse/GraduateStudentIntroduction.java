package cuhk.cse;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

public class GraduateStudentIntroduction implements IntroductionInterceptor,
		GraduateStudent {
	
	private String name;
	public void setName(String name){
		this.name = name;
	}
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		// If invoked method is defined by GraduateStudent
		if (implementsInterface(methodInvocation.getMethod()
				.getDeclaringClass())) {
			// Invoke mixin behavior
			return methodInvocation.getMethod().invoke(this,
					methodInvocation.getArguments());
		} else {
			return methodInvocation.proceed();
		}

	}

	@Override
	public boolean implementsInterface(Class clazz) {
		// if implements GraduateStudent class
		return clazz.isAssignableFrom(GraduateStudent.class);
	}

	@Override
	public void doProject() {
		if(this.name == null)
			name = "A graduate studnet";
		System.out.println(this.name + " do project in company.");
	}

}
