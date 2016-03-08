package Maze.logic;

import java.util.Random;
import static Maze.logic.Table.*;

public class Maze 
{
	public enum State { PLAYING, WON, LOST, SLAYED };

	private State state;

	private Table table;								//Object Table
	private Hero hero;									//Object Hero
	private Dragon dragon;								//Object Dragon
	private Sword sword;								//Object Sword
	private Random r;
	
	public Maze(){
		table = new Table();
		hero = new Hero();
		dragon = new Dragon();
		sword = new Sword();
		r = new Random();
	};
		
	public Maze(char[][] newMaze)
	{
		this();
		table = new Table(newMaze);
		retrieveElems();
	}
	
	public void initialize()
	{
		setState(State.PLAYING);				//Setting Game to play
		hero.heroDeploy(table);					//Deploy Hero in table
		dragon.dragonDeploy(table);				//Deploy Dragon in table
		sword.swordDeploy(table);				//Deploy Sword in table		
		print();								//Printing Table
	}

	public void setState(State status)
	{
		state = status;
	}

	public State getState()
	{
		return state;
	}
	
	public void print()
	{
		table.printTable();
	}

	public boolean updateHero(String c)
	{
		if(c == "Up")
		{
			int newPosX =  0 + hero.getX();
			int newPosY = -1 + hero.getY();

			if(heroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				System.out.println("Up");
				return true;
			}
			return false;
		}
		if(c == "Left")
		{
			int newPosX =  -1 + hero.getX();
			int newPosY = 	0 + hero.getY();

			if(heroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				System.out.println("Left");
				return true;
			}
			return false;


		}
		if(c == "Down")
		{
			int newPosX =   0 + hero.getX();
			int newPosY =  +1 + hero.getY();

			if(heroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				System.out.println("Down");
				return true;
			}
			return false;

		}
		if(c == "Right")
		{
			int newPosX =  +1 + hero.getX();
			int newPosY = 	0 + hero.getY();

			if(heroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				System.out.println("Right");
				return true;
			}
			return false;

		}
		return false;
	}
	
	public boolean heroMove(int nPosX, int nPosY)
	{
		char Elem = table.getElem(nPosX, nPosY);
		char Hero = hero.getHeroState();

		//HERO GATHERING THE SWORD
		if(Elem == Table.SWORD)
		{
			table.setElem(hero.getX(), hero.getY(), Table.SPACE);
			table.setElem(nPosX, nPosY, hero.heroArmed());
			return true;
		}

		//CASE WHEN HERO UNARMED CONFRONTS DRAGON, DIES HORRIBLY
		else if(Elem == Table.DRAGON && Hero == Table.HERO)
		{
			table.setElem(hero.getX(), hero.getY(), Table.SPACE);
			setState(State.LOST);
			return true;
		}

		//CASE WHEN HERO IS ARMED AND CONFRONTS SLEEPY OR AWAKEN DRAGON, DRAGON GETS CRIPPLED INT PIECES
		else if((Elem == Table.DRAGON && Hero == Table.ARMOR)||
				(Elem == Table.SLEEPY && Hero == Table.ARMOR))
		{
			table.setElem(heroGetX(), hero.getY(), Table.SPACE);
			table.setElem(nPosX, nPosY, Hero);
			setState(State.SLAYED);
			return true;
		}

		//SLEEPY DRGON AND HERO UNAMRMED
		else if(Elem == SLEEPY && Hero == HERO)
		{
			//SIMPLY RETURNS FALSE FOR THE HERO CANNOT MAGICLLY TRESPASS THE DRAGON
			return false;
		}
		//HERO FACES DRAGON SITTING ON SWORD
		else if((Elem == Table.DRASWO && Hero == Table.HERO)||
				(Elem == Table.DRASWO && Hero == Table.ARMOR))
		{
			return false;
		}
		//KILLING DRAGON AND ENTERING THE EXIT
		else if(Elem == EXIT && getState() == State.SLAYED)
		{
			table.setElem(hero.getX(), hero.getY(), SPACE);
			table.setElem(nPosX, nPosY, Hero);
			setState(State.WON);
			return true;
		}
		//NORMAL HERO MOVEMENT
		else if(Elem == SPACE)
		{
			table.setElem(hero.getX(), hero.getY(), SPACE);
			table.setElem(nPosX, nPosY, Hero);
			return true;
		}
		else
			return false;
	}

	public boolean updateDragon()
	{
		int move;
		int newPosX = dragon.getX();
		int newPosY = dragon.getY();
		char Dragon = dragon.getDragonState();

		move = r.nextInt(2);

		//MOVIMENTO
		if(move == 0 && Dragon != SLEEPY)
		{
			//MOVIMENTO OBRIGATORIO
			while(true)
			{	
				move = r.nextInt(4);
				//UPPER MOVEMENT
				if(move == 0)
				{
					int change = -1;
					if(dragonMove(newPosX, newPosY + change) == true)
						return true;
				}
				//DOWN MOVEMENT
				else if(move == 1)
				{
					int change = +1;
					if(dragonMove(newPosX, newPosY + change) == true)
						return true;
				}
				//LEFT MOVEMENT
				else if(move == 2)
				{
					int change = -1;
					if(dragonMove(newPosX+change, newPosY) == true)
						return true;
				}
				//RIGHT MOVEMENT
				else if(move == 3)
				{
					int change = +1;
					if(dragonMove(newPosX+change, newPosY) == true)
						return true;
				}
				else return false;
			}
		}
		else if(move == 0 && Dragon == SLEEPY)
		{
			move = r.nextInt(2);
			if(move == 0)
			{
				return false;
			}
			else if(move == 1)
			{
				if(Dragon == DRAGON)
				{
					dragon.sleepDragon();
					table.setElem(newPosX, newPosY, SLEEPY);
					return false;
				}
				else if(Dragon == SLEEPY)
				{
					dragon.awakeDragon();
					table.setElem(newPosX, newPosY, DRAGON);
					return false;
				}
				else
					return false;
			}
		}
		else if(move == 1 && Dragon != DRASWO)
		{
			move = r.nextInt(2);
			if(move == 0)
			{
				return false;
			}
			else if(move == 1)
			{
				if(Dragon == DRAGON)
				{
					dragon.sleepDragon();
					table.setElem(newPosX, newPosY, SLEEPY);
					System.out.println("Dragon is Sleeping!");
					return false;
				}
				else if(Dragon == SLEEPY)
				{
					dragon.awakeDragon();
					table.setElem(newPosX, newPosY, DRAGON);
					System.out.println("DRAGON AS AWAKEN!");
					return false;
				}
				else
					return false;
			}
			else 
				return false;
		}
		return false;
	}
	public boolean dragonMove(int newPosX, int newPosY)
	{
		char Elem = table.getElem(newPosX, newPosY);
		char Dragon = dragon.getDragonState();
		//FOR NORMAL DRAGON AND SPACE MOVEMENT
		if(Elem == SPACE && Dragon == DRAGON)
		{
			table.setElem(dragon.getX(), dragon.getY(),SPACE);
			table.setElem(newPosX, newPosY, DRAGON);
			dragon.setCoord(newPosX, newPosY);
			return true;
		}
		//FOR DRAGON TO SWORD MOVEMENT
		else if(Elem == SWORD)
		{
			table.setElem(dragon.getX(), dragon.getY(),SPACE);
			table.setElem(newPosX, newPosY, DRASWO);
			dragon.setCoord(newPosX, newPosY);
			dragon.swordDragon();
			return true;
		}
		//GETTING OUT OF THE SWORD
		else if(Elem == SPACE && Dragon == DRASWO)
		{
			table.setElem(dragon.getX(), dragon.getY(),SWORD);
			table.setElem(newPosX, newPosY, DRAGON);
			dragon.setCoord(newPosX, newPosY);
			dragon.noSwordDragon();
			return true;
		}
		//DRAGON KILLING HERO, ARMED OR UNARMED
		else if(Elem == HERO && Dragon == DRAGON || Elem == ARMOR && Dragon == DRAGON)
		{
			table.setElem(dragon.getX(), dragon.getY(),SPACE);
			table.setElem(newPosX, newPosY, DRAGON);
			dragon.setCoord(newPosX, newPosY);
			setState(State.LOST);
			return true;
		}
		//DRAGON KILLING HERO AND GETTING OUT OF SWORD
		else if(Elem == HERO && Dragon == DRASWO)
		{
			table.setElem(dragon.getX(), dragon.getY(),SWORD);
			table.setElem(newPosX, newPosY, DRAGON);
			dragon.setCoord(newPosX, newPosY);
			setState(State.LOST);
			return true;
		}
		return false;
	}
	public void retrieveElems()
	{
		int column = getColumn();
		int line = getLine();
		
		for(int i = 0; i < line; i++)
		{
			for(int j = 0; j < column; j++)
			{
				if(table.getElem(i,j) == SWORD)
					sword.setCoord(i, j);
				else if(table.getElem(i, j) == HERO)
					hero.setCoord(i, j);
				else if(table.getElem(i,j) == DRAGON)
					dragon.setCoord(i, j);
			}
		}
	}

	//MUTATIONAL FUNCTIONS
	public int getColumn()
	{
		return table.column();
	}
	public int getLine()
	{
		return table.line();
	}
	public boolean heroMoveLeft()
	{
		return updateHero("Left");
	}
	public boolean heroMoveRight()
	{
		return updateHero("Right");
	}
	public boolean heroMoveUp()
	{
		return updateHero("Up");
	}
	public boolean heroMoveDown()
	{
		return updateHero("Down");
	}
	public int heroGetX()
	{
		return hero.getX();
	}
	public int heroGetY()
	{
		return hero.getY();
	}
	public int dragonGetX()
	{
		return dragon.getX();
	}
	public int dragonGetY()
	{
		return dragon.getY();
	}
	
}
