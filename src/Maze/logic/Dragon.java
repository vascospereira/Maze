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

	public Dragon(char draswo) {
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
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public Dragon clone(){
		return new Dragon(this);
	}
}
