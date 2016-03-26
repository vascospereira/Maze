package Maze.logic;
import java.util.Random;

public class Sword extends Element
{
	
	public Sword(int y, int x) 
	{
		super(y, x, 'S');
	}
	
	public Sword() 
	{
		this(1,7);
	}
	
	public void swordDeploy(Table table)
	{
		Random r = new Random();
		while(true)
		{
			int x = r.nextInt(table.getHeight() - 2 ) +1;
			int y = r.nextInt(table.getHeight() - 2 ) +1;
			if(table.getElem(x, y) == Table.SPACE)
			{
				table.setElem(x, y, this.getElem());
				this.setX(x);
				this.setY(y);
				break;
			}
			
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
