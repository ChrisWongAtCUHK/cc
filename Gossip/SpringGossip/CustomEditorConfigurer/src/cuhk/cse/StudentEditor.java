package cuhk.cse;

import java.beans.PropertyEditorSupport;

public class StudentEditor extends PropertyEditorSupport {
	public void setAsText(String text) {
        String[] strs = text.split(",");
        int number = Integer.parseInt(strs[1]);
        
        Student student = new Student();
        student.setName(strs[0]);
        student.setNumber(number);
        
        setValue(student);
    }
}
