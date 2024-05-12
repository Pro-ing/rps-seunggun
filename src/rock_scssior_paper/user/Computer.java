package rock_scssior_paper.user;

public class Computer implements IPlayer{
	
	private String name;
	private int age;
    private String item;
	
    
	public void setName() {
		this.name = "computer";
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getAge() {
		return 0;
	}
	
	@Override
	public void getItem() {
	}
}
