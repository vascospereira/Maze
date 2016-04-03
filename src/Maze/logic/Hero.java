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

	/**
	 * Sets an Hero armed
	 * 
	 * @return The Hero armed
	 */
	public char heroArmed()
	{
		this.setElem('A');
		return this.getElem();
	}
	/**
	 * 
	 * @return Hero state
	 */
	public char getHeroState()
	{
		return this.getElem();
	}
	/**
	 * Puts an Hero in the table
	 * 
	 * @param table Table where Hero will be deployed
	 */
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
