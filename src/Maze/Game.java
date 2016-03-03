package Maze;

import java.util.Random;

public class Game 
{
	enum State { PLAYING, WON, LOST, SLAYED };

	private State state;

	Table table;								//Object Table
	Hero hero;									//Object Hero
	Dragon dragon;								//Object Dragon
	Sword sword;								//Object Sword
	Random r;

	public void Initialize()
	{
		table = new Table();
		hero = new Hero();
		dragon = new Dragon();
		sword = new Sword();
		r = new Random();

		setState(State.PLAYING);				//Setting Game to play
		hero.HeroDeploy(table);					//Deploy Hero in table
		dragon.DragonDeploy(table);				//Deploy Dragon in table
		sword.SwordDeploy(table);				//Deploy Sword in table
		Print();								//Printing Table
	}

	public void setState(State status)
	{
		state = status;
	}

	public State getState()
	{
		return state;
	}

	public void Print()
	{
		table.PrintTable();
	}

	public boolean Update(char c)
	{
		if(getState() != State.SLAYED)
		{
			DragonMove();
		}
		
		if(c == 'W' || c == 'w')
		{
			int newPosX =  0 + hero.getX();
			int newPosY = -1 + hero.getY();

			if(HeroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				System.out.println("Up");
				return true;
			}
			return false;
		}
		if(c == 'A' || c == 'a')
		{
			int newPosX =  -1 + hero.getX();
			int newPosY = 	0 + hero.getY();

			if(HeroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				System.out.println("Left");
				return true;
			}
			return false;


		}
		if(c == 'S' || c == 's')
		{
			int newPosX =   0 + hero.getX();
			int newPosY =  +1 + hero.getY();

			if(HeroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				System.out.println("Down");
				return true;
			}
			return false;

		}
		if(c == 'D' || c == 'd')
		{
			int newPosX =  +1 + hero.getX();
			int newPosY = 	0 + hero.getY();

			if(HeroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				System.out.println("Right");
				return true;
			}
			return false;

		}
		return false;
	}
	public boolean DragonMove()
	{
		int move;
		int newPosX = dragon.getX();
		int newPosY = dragon.getY();
		
		while(true)
		{	
			move = r.nextInt(4)+1;
			
			//NO MOVEMENT
			/*
			if(move == 0)
			{
				return false;
			}
			*/
			//UPPER MOVEMENT
			if(move == 1)
			{
				int change = -1;
				if(table.getElem(newPosX, newPosY + change) == table.SPACE)
				{
					table.setElem(newPosX, newPosY,table.SPACE);
					table.setElem(newPosX, newPosY + change, table.DRAGON);
					dragon.setCoord(newPosX, newPosY + change);
					return true;
				}
			}
			//DOWN MOVEMENT
			else if(move == 2)
			{
				int change = +1;
				if(table.getElem(newPosX, newPosY + change) == table.SPACE)
				{
					table.setElem(newPosX, newPosY,table.SPACE);
					table.setElem(newPosX, newPosY + change, table.DRAGON);
					dragon.setCoord(newPosX, newPosY + change);
					return true;
				}
			}
			//LEFT MOVEMENT
			else if(move == 3)
			{
				int change = -1;
				if(table.getElem(newPosX+change, newPosY) == table.SPACE)
				{
					table.setElem(newPosX, newPosY,table.SPACE);
					table.setElem(newPosX+change, newPosY, table.DRAGON);
					dragon.setCoord(newPosX+change, newPosY);
					return true;
				}
			}
			else if(move == 4)
			{
				int change = +1;
				if(table.getElem(newPosX+change, newPosY) == table.SPACE)
				{
					table.setElem(newPosX, newPosY,table.SPACE);
					table.setElem(newPosX+change, newPosY, table.DRAGON);
					dragon.setCoord(newPosX+change, newPosY);
					return true;
				}
			}
			
		}
	}

	public boolean HeroMove(int nPosX, int nPosY)
	{
		char Elem = table.getElem(nPosX, nPosY);
		char Hero = hero.getHeroState();
		
		//HERO GATHERING THE SWORD
		if(Elem == table.SWORD)
		{
			table.setElem(hero.getX(), hero.getY(), table.SPACE);
			table.setElem(nPosX, nPosY, hero.heroArmed());
			return true;
		}
		
		//CASE WHEN HERO UNARMED CONFRONTS DRAGON, DIES HORRIBLY
		else if(Elem == table.DRAGON && Hero == table.HERO)
		{
			table.setElem(hero.getX(), hero.getY(), table.SPACE);
			setState(State.LOST);
			return true;
		}
		
		//CASE WHEN HERO IS ARMED AND CONFRONTS SLEEPY OR AWAKEN DRAGON, DRAGON GETS CRIPPLED INT PIECES
		else if((Elem == table.DRAGON && Hero == table.ARMOR)||
				(Elem == table.SLEEPY && Hero == table.ARMOR))
		{
			table.setElem(hero.getX(), hero.getY(), table.SPACE);
			table.setElem(nPosX, nPosY, Hero);
			setState(State.SLAYED);
			return true;
		}

		//SLEEPY DRGON AND HERO UNAMRMED
		else if(Elem == table.SLEEPY && Hero == table.HERO)
		{
			//SIMPLY RETURNS FALSE FOR THE HOR CANNOT MAGICLLY TRESPASS THE DRAGON
			return false;
		}
		//KILLING DRAGON AND ENTERING THE EXIT
		else if(Elem == table.EXIT && getState() == State.SLAYED)
		{
			table.setElem(hero.getX(), hero.getY(), table.SPACE);
			table.setElem(nPosX, nPosY, Hero);
			setState(State.WON);
			return true;
		}
		//NORMAL HERO MOVEMENT
		else if(Elem == table.SPACE)
		{
			table.setElem(hero.getX(), hero.getY(), table.SPACE);
			table.setElem(nPosX, nPosY, Hero);
			return true;
		}
		else
			return false;
	}
}
