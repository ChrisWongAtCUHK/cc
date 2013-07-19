
// http://openhome.cc/Gossip/DesignPattern/CommandPattern.htm
public class Main {
	public static void main(String[] args){
		TakeCourseOperation tco = new TakeCourseOperation();
		String[] studenCourseRegistries = {"SammiRegistry", "ChrisWongRegistry"};
		tco.addCourse(studenCourseRegistries[0], new SammiRegistry());
		tco.addCourse(studenCourseRegistries[1], new ChrisWongRegistry());
		
		// Run if in need
		tco.enrollCourse(studenCourseRegistries[0]);
		tco.enrollCourse(studenCourseRegistries[1]);
	}
}
