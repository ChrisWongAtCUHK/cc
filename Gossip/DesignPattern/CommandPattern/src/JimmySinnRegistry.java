
public class JimmySinnRegistry implements CourseRegistry {

	@Override
	public void registry(TakeCourse tc) {
		System.out.println("Jimmy Sinn courses registry");
		tc.takeMultiMedia();
		tc.takeComputerSecurity();
		tc.takeOpenSource();
	}

}
