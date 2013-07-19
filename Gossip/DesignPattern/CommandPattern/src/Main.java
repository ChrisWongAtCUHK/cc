
// http://openhome.cc/Gossip/DesignPattern/CommandPattern.htm
public class Main {
	public static void main(String[] args){
		TakeCourseOperation tco = new TakeCourseOperation();
		String[] studenCourseRegistries = {"SammiRegistry", "ChrisWongRegistry", "JimmySinnRegistry"};
		tco.addCourse(studenCourseRegistries[0], new SammiRegistry());
		tco.addCourse(studenCourseRegistries[1], new ChrisWongRegistry());
		tco.addCourse(studenCourseRegistries[2], new JimmySinnRegistry());
		
		// Run if in need
		tco.enrollCourse(studenCourseRegistries[0]);
		tco.enrollCourse(studenCourseRegistries[1]);
		tco.enrollCourse(studenCourseRegistries[2]);
	}
}
