package cuhk.cse;

public class CSStudent implements Student {

	private String name;
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public void doAssignment() {
		if(this.name == null)
			name = "A CSer";
		System.out.println(this.name + " do student assignment.");
	}
}
