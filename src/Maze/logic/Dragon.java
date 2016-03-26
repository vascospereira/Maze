package Maze.logic;

public class Dragon extends Element
{
	
	public Dragon(int y, int x) 
	{
		super(y, x, 'D');
	}
	
	public Dragon() 
	{
		this(1,3);
	}
	
	public Dragon(Dragon dragon) {
		super(dragon);
	}

	public void dragonDeploy(Table table)
	{
		table.deployElemTable(this.getX(), this.getY(), this.getElem());
	}
	
	public void sleepDragon() 
	{
		this.setElem('d');
	}
	
	public void awakeDragon() 
	{
		this.setElem('D');
	}
	
	public void swordDragon()
	{
		this.setElem('F');
	}
	
	public void noSwordDragon()
	{
		this.setElem('D');
	}
	
	public char getDragonState()
	{
		return this.getElem();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public Dragon clone(){
		return new Dragon(this);
	}
}
