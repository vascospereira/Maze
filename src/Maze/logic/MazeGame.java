package Maze.logic;

import java.util.Random;
import static Maze.logic.Table.*;
import java.util.ArrayList;

public class MazeGame 
{
	public enum State { PLAYING, WON, LOST, SLAYED };

	private State state;
	private Table table;								//Object Table
	private Hero hero;									//Object Hero								//Object Dragon
	private Sword sword;								//Object Sword
	private ArrayList<Dragon> dragons;					//Object Dragons
	private Random r;

	public MazeGame()
	{
		table = new Table();
		hero = new Hero();
		sword = new Sword();
		r = new Random();
		dragons = new ArrayList<Dragon>();
	}
	/*
	 * Random Maze Constructor
	 */
	public MazeGame(char[][] newMaze, int numOfDragons)
	{
		this();
		table.setTable(newMaze);
		retrieveElems();
		dragonsControler(numOfDragons);
	}
	
	public MazeGame(int numOfDragons)
	{
		this();
		retrieveElems();
		dragonsControler(numOfDragons);
	}
	
	/*
	 * Constructor for tests
	 */
	public MazeGame(char[][] newMaze)
	{
		this();
		table.setTable(newMaze);
		retrieveElems();
	}

	/*
	 * Copy constructor
	 */
	public MazeGame(MazeGame maze) {
		state = maze.getState();
		table = maze.getTable();								
		hero = maze.getHero();							
		sword = maze.getSword();			
		dragons = maze.getDragons();
		r = maze.getR();
	}

	public void initialize()
	{
		setState(State.PLAYING);				//Setting Game to play
		hero.heroDeploy(table);					//Deploy Hero in table
		deployDragons(dragons);					//Deploy Dragon in table
		sword.swordDeploy(table);				//Deploy Sword in table		
	}
	
	public void dragonsControler(int numOfDragons){
		while(numOfDragons > 0)
		{
			Dragon dragon = new Dragon();
			int x;
			int y;
			while(true)
			{
				x = r.nextInt(table.getWidth());
				y = r.nextInt(table.getHeight());
				if(emptySpace(x,y) == true)
					break;
			}
			dragon.setCoord(x, y);
			dragons.add(dragon);
			numOfDragons--;
		}
	}

	public boolean emptySpace(int x, int y)
	{
		if(noDragon(x,y) == true)
		{
			if((sword.getX() == x && sword.getY() == y) || (hero.getX() == x && hero.getY() == y) || table.getElemTable(x, y) != Table.SPACE)
				return false;
			else
				return true;
		}
		else
			return false;

	}
	
	public boolean noDragon(int x, int y)
	{
		for(int i = 0; i < dragons.size(); i++)
		{
			if(dragons.get(i).getX() == x && dragons.get(i).getY() == y)
				return false;
		}
		return true;
	}

	public void setState(State status)
	{
		state = status;
	}

	public State getState(){
		return state;
	}
	
	public Hero getHero() {
		return hero;
	}

	public Sword getSword() {
		return sword;
	}

	public ArrayList<Dragon> getDragons() {
		return dragons;
	}

	public Random getR() {
		return r;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public void setSword(Sword sword) {
		this.sword = sword;
	}

	public void setDragons(ArrayList<Dragon> dragons) {
		this.dragons = dragons;
	}

	public void setR(Random r) {
		this.r = r;
	}

	public boolean updateHero(String move)
	{
		if(move == "Up")
		{
			int newPosX = hero.getX();
			int newPosY = hero.getY() - 1;

			if(heroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				return true;
			}
			return false;
		}
		else if(move == "Left")
		{
			int newPosX = hero.getX() - 1;
			int newPosY = hero.getY();

			if(heroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				return true;
			}
			return false;
		}
		else if(move == "Down")
		{
			int newPosX =  hero.getX();
			int newPosY =  hero.getY() + 1;

			if(heroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				return true;
			}
			return false;

		}
		else if(move == "Right")
		{
			int newPosX = hero.getX() + 1;
			int newPosY = hero.getY();

			if(heroMove(newPosX, newPosY) == true)
			{
				hero.setCoord(newPosX, newPosY);
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean heroMove(int nPosX, int nPosY)
	{
		char Elem = table.getElemTable(nPosX, nPosY);
		char Hero = hero.getHeroState();

		/*
		 * Hero gather Sword
		 */
		if(Elem == Table.SWORD)
		{
			table.setElemTable(hero.getX(), hero.getY(), Table.SPACE);
			table.setElemTable(nPosX, nPosY, hero.heroArmed());
			return true;
		}

		/*
		 * Case when Hero Unarmed Confronts Dragon, Dies Horribly
		 */
		else if(Elem == Table.DRAGON && Hero == Table.HERO)
		{
			table.setElemTable(hero.getX(), hero.getY(), Table.SPACE);
			setState(State.LOST);
			return true;
		}

		/*
		 * Case when Hero Unarmed Confronts Sleepy or Awaken Dragon, Dragon Gets Crippled into pieces
		 */
		else if((Elem == Table.DRAGON && Hero == Table.ARMOR)||
				(Elem == Table.SLEEPY && Hero == Table.ARMOR))
		{
			table.setElemTable(heroGetX(), hero.getY(), Table.SPACE);
			table.setElemTable(nPosX, nPosY, Hero);
			deadDragon(nPosX, nPosY);
			return true;
		}

		/*
		 * Sleepy Dragon and Unarmed Hero
		 */
		else if(Elem == SLEEPY && Hero == HERO)
		{
			//SIMPLY RETURNS FALSE FOR THE HERO CANNOT MAGICLLY TRESPASS THE DRAGON
			return false;
		}
		/*
		 * Hero faces Dragon sitting on Sword
		 */
		else if((Elem == DRASWO && Hero == HERO)||
				(Elem == DRASWO && Hero == ARMOR))
		{
			return false;
		}
		/*
		 * Killing Dragon and exit
		 */
		else if(Elem == EXIT && getState() == State.SLAYED)
		{
			table.setElemTable(hero.getX(), hero.getY(), SPACE);
			table.setElemTable(nPosX, nPosY, Hero);
			setState(State.WON);
			return true;
		}
		/*
		 * Normal hero movement
		 */
		else if(Elem == SPACE)
		{
			table.setElemTable(hero.getX(), hero.getY(), SPACE);
			table.setElemTable(nPosX, nPosY, Hero);
			return true;
		}
		else
			return false;
	}

	public boolean updateDragon(Dragon dragon)
	{
		int move;
		int newPosX = dragon.getX();
		int newPosY = dragon.getY();
		char Dragon = dragon.getDragonState();

		move = r.nextInt(2);

		/*
		 * Movement
		 */
		if(move == 0 && Dragon != SLEEPY)
		{
			/*
			 * Compulsory move
			 */
			while(true)
			{	
				move = r.nextInt(4);
				/*
				 * Upper movement
				 */
				if(move == 0)
				{
					int change = -1;
					if(dragonMove(dragon, newPosX, newPosY + change) == true)
						return true;
				}
				/*
				 * Down movement
				 */
				else if(move == 1)
				{
					int change = +1;
					if(dragonMove(dragon, newPosX, newPosY + change) == true)
						return true;
				}
				/*
				 * Left movement
				 */
				else if(move == 2)
				{
					int change = -1;
					if(dragonMove(dragon, newPosX + change, newPosY) == true)
						return true;
				}
				/*
				 * Right movement
				 */
				else if(move == 3)
				{
					int change = +1;
					if(dragonMove(dragon, newPosX + change, newPosY) == true)
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
					table.setElemTable(newPosX, newPosY, SLEEPY);
					return false;
				}
				else if(Dragon == SLEEPY)
				{
					dragon.awakeDragon();
					table.setElemTable(newPosX, newPosY, DRAGON);
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
					table.setElemTable(newPosX, newPosY, SLEEPY);
					return false;
				}
				else if(Dragon == SLEEPY)
				{
					dragon.awakeDragon();
					table.setElemTable(newPosX, newPosY, DRAGON);
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
	public boolean dragonMove(Dragon dragon, int newPosX, int newPosY)
	{
		char Elem = table.getElemTable(newPosX, newPosY);
		char Dragon = dragon.getDragonState();
		/*
		 * For normal Dragon and space movement
		 */
		if(Elem == SPACE && Dragon == DRAGON)
		{
			table.setElemTable(dragon.getX(), dragon.getY(),SPACE);
			table.setElemTable(newPosX, newPosY, DRAGON);
			dragon.setCoord(newPosX, newPosY);
			return true;
		}
		/*
		 * FOR DRAGON TO SWORD MOVEMENT
		 */
		else if(Elem == SWORD)
		{
			table.setElemTable(dragon.getX(), dragon.getY(),SPACE);
			table.setElemTable(newPosX, newPosY, DRASWO);
			dragon.setCoord(newPosX, newPosY);
			dragon.swordDragon();
			return true;
		}
		/*
		 * GETTING OUT OF THE SWORD
		 */
		else if(Elem == SPACE && Dragon == DRASWO)
		{
			table.setElemTable(dragon.getX(), dragon.getY(),SWORD);
			table.setElemTable(newPosX, newPosY, DRAGON);
			dragon.setCoord(newPosX, newPosY);
			dragon.noSwordDragon();
			return true;
		}
		/*
		 * DRAGON KILLING HERO, ARMED OR UNARMED
		 */
		else if(Elem == HERO && Dragon == DRAGON || Elem == ARMOR && Dragon == DRAGON)
		{
			table.setElemTable(dragon.getX(), dragon.getY(),SPACE);
			table.setElemTable(newPosX, newPosY, DRAGON);
			dragon.setCoord(newPosX, newPosY);
			setState(State.LOST);
			return true;
		}
		/*
		 * DRAGON KILLING HERO AND GETTING OUT OF SWORD
		 */
		else if(Elem == HERO && Dragon == DRASWO)
		{
			table.setElemTable(dragon.getX(), dragon.getY(),SWORD);
			table.setElemTable(newPosX, newPosY, DRAGON);
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
				if(table.getElemTable(i,j) == SWORD)
					sword.setCoord(i, j);
				else if(table.getElemTable(i, j) == HERO)
					hero.setCoord(i, j);
				else if(table.getElemTable(i,j) == DRAGON)
				{
					Dragon dragon = new Dragon();
					dragons.add(dragon);
					dragon.setCoord(i, j);
				}
				else if(table.getElemTable(i, j) == ARMOR)
				{
					hero.setCoord(i, j);
					hero.heroArmed();
					sword.setCoord(i, j);
				}
			}
		}
	}

	public void updateDragons()
	{
		for(int i = 0; i < dragons.size(); i++)
		{
			updateDragon(dragons.get(i));
		}
	}
	public void deployDragons(ArrayList<Dragon> dragons)
	{
		for(int i = 0; i < dragons.size(); i++)
		{
			dragons.get(i).dragonDeploy(table);
		}
	}
	public void deadDragon(int x, int y)
	{
		if(dragons.size() == 1)
		{
			dragons.clear();
			setState(State.SLAYED);
		}
		else
		{
			for(int i = 0; i < dragons.size(); i++)
			{
				if(dragons.get(i).getX() == x && dragons.get(i).getY() == y)
				{
					dragons.remove(i);
					setState(State.PLAYING);
				}
			}
		}
	}

	public int getColumn()
	{
		return table.getHeight();
	}
	public int getLine()
	{
		return table.getWidth();
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
		return dragons.get(0).getX();
	}
	public int dragonGetY()
	{
		return dragons.get(0).getY();
	}
	public Table getTable()
	{
		return table;
	}
	public Dragon getDragon()
	{
		return dragons.get(0);
	}
	public char getHeroState()
	{
		return hero.getHeroState();
	}
	public char getDragonState()
	{
		return dragons.get(0).getDragonState();
	}

	@Override
	public String toString() 
	{
		return table.toString();
	}
	
	public MazeGame clone(){
		return new MazeGame(this);
	}
}