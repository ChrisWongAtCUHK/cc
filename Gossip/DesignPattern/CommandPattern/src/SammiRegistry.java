
public class SammiRegistry implements CourseRegistry {

	@Override
	public void registry(TakeCourse tc) {
		System.out.println("Sammi courses registry");
		tc.takeComputerArchitecture();
		tc.takeMultiMedia();
	}

}
