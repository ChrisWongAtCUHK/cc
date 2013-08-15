package cuhk.cse;

public class CSStudent implements Student {

	private String name;
	
	@Override
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public String getName(){
		return this.name;
	}

}
