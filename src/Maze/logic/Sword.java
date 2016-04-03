package Maze.logic;
import java.util.Random;
/**
 * 
 * Sword Class
 *
 */
public class Sword extends Element
{
	/**
	 * Sword Constructor in x and y position
	 * @param y
	 * @param x
	 */
	public Sword(int y, int x) 
	{
		super(y, x, Table.SWORD);
	}
	/**
	 * Default Sword constructor
	 */
	public Sword() 
	{
		this(1,7);
	}
	/**
	 * Sword constructor, copying another existing already
	 * @param sword
	 */
	public Sword(Sword sword) {
		super(sword);
	}

	/**
	 * Deploys a Sword in the table
	 * 
	 * @param table Table where Sword will be deployed
	 */
	public void swordDeploy(Table table)
	{
		Random r = new Random();
		while(true)
		{
			int x = r.nextInt(table.getHeight() - 2 ) +1;
			int y = r.nextInt(table.getHeight() - 2 ) +1;
			if(table.getElemTable(x, y) == Table.SPACE)
			{
				table.setElemTable(x, y, this.getElem());
				this.setX(x);
				this.setY(y);
				break;
			}
			
		}
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
	public Sword clone() {
		return new Sword(this);
	}
}
