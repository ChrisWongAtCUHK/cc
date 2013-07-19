import java.util.*;

public class TakeCourseOperation {
	private Map<String, CourseRegistry> courseRegistries = new HashMap<String, CourseRegistry>();
	private TakeCourse tc = new TakeCourseImpl();
	
	public void addCourse(String studentCourses, CourseRegistry courseRegistry){
		courseRegistries.put(studentCourses, courseRegistry);
		
	}
	
	public void enrollCourse(String studentCourses){
		courseRegistries.get(studentCourses).registry(tc);
	}
}
