package Maze.logic;

public class Hero extends Element
{
	
	public Hero(int y, int x) 
	{
		super(y, x, 'H');
	}
	
	public Hero() 
	{
		this(1,1);
	}
	
	public Hero(Hero hero) {
		super(hero);
	}

	public char heroArmed()
	{
		this.setElem('A');
		return this.getElem();
	}
	
	public char getHeroState()
	{
		return this.getElem();
	}
	
	public void heroDeploy(Table table)
	{
		table.deployElemTable(this.getX(), this.getY(), this.getElem());
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public Hero clone() {
		return new Hero(this);
	}
	
}
