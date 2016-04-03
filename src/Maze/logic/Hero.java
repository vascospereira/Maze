package Maze.logic;
/**
 * 
 * Hero class, extends Element
 *
 */
public class Hero extends Element
{
	/**
	 * Hero constructor on x and y position
	 * @param y
	 * @param x
	 */
	public Hero(int y, int x) 
	{
		super(y, x, Table.HERO);
	}
	/**
	 * Default Hero Constructor
	 */
	public Hero() 
	{
		this(1,1);
	}
	/**
	 * Hero constructor, based uppon another Hero
	 * @param hero
	 */
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
		this.setElem(Table.ARMOR);
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
	/**
	 * @Override toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	/**
	 * @Override clone()
	 */
	@Override
	public Hero clone() {
		return new Hero(this);
	}	
}
