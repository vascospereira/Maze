package Maze.logic;
/**
 * 
 * Dragon Class, extends Element
 *
 */
public class Dragon extends Element
{
/**
 * Dragon constructor in x and y	
 * @param y
 * @param x
 */
	public Dragon(int y, int x) 
	{
		super(y, x, 'D');
	}
	/**
	 * Dragon default constructor 
	 */
	public Dragon() 
	{
		this(1,3);
	}
	/**
	 * Dragon constructor using another Dragon
	 * @param dragon
	 */
	public Dragon(Dragon dragon) {
		super(dragon);
	}
	/**
	 * Dragon constructor with character
	 * @param draswo
	 */
	public Dragon(char draswo) 
	{
		super(1,1,draswo);
	}

	/**
	 * Deploys dragons in the table
	 * @param table Table to be deployed the dragons
	 */
	public void dragonDeploy(Table table)
	{
		table.deployElemTable(this.getX(), this.getY(), this.getElem());
	}
	/**
	 * Sets Dragon to sleep
	 */
	public void sleepDragon() 
	{
		this.setElem('d');
	}
	/**
	 * Sets awake Dragon
	 */
	public void awakeDragon() 
	{
		this.setElem('D');
	}
	/**
	 * Sets Dragon with Sword
	 */
	public void swordDragon()
	{
		this.setElem('F');
	}
	/**
	 * Dragon gets out of sword
	 */
	public void noSwordDragon()
	{
		this.setElem('D');
	}
	/**
	 * Gets Dragon state
	 * 
	 * @return Dragon state
	 */
	public char getDragonState()
	{
		return this.getElem();
	}
	/**
	 * @Overrid toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	/**
	 * @Overrid clone
	 */
	@Override
	public Dragon clone(){
		return new Dragon(this);
	}
}
