
public class ChrisWongRegistry implements CourseRegistry {
	@Override
	public void registry(TakeCourse tc) {
		System.out.println("Chris Wong courses registry");
		tc.takeMultiMedia();
		tc.takeOpenSource();
	}
}
