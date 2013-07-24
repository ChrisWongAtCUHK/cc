package cuhk.cse;

public class ChrisBean {
	private String chrisWord;
	private Student student;
	
	public ChrisBean(){
		
	}
	
	public void setChrisWord(String chrisWord){
		this.chrisWord = chrisWord;
	}
	
	public String getChrisWord(){
		return this.chrisWord;
	}
	
	public Student getStudent(){
		return this.student;
	}
	
	public void setStudent(Student student){
		this.student = student;
	}
}
