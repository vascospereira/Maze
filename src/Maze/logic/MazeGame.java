package Maze.logic;

import java.util.Random;
import Maze.cli.Game.Direction;
import static Maze.logic.Table.*;
import java.util.ArrayList;

public class MazeGame 
{
	/**
	 *
	 *Game States
	 */
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
	/**
	 * Creates a MazeGame 
	 * @param newMaze sets a newMaze
	 * @param numOfDragons sets a number of dragons in the game
	 */
	public MazeGame(char[][] newMaze, int numOfDragons)
	{
		this();
		table.setTable(newMaze);
		retrieveElems();
		dragonsControler(numOfDragons);
	}
	/**
	 * Creates a MazeGame
	 * @param numOfDragons sets a number of dragons inn the game
	 */
	public MazeGame(int numOfDragons)
	{
		this();
		retrieveElems();
		dragonsControler(numOfDragons);
	}

	/**
	 * Creates a MazeGame for Tests
	 * @param newMaze sets a new maze table 
	 */
	public MazeGame(char[][] newMaze)
	{
		this();
		table.setTable(newMaze);
		retrieveElems();
	}

	/**
	 * Constructor that copies a an object
	 * 
	 * @param maze sets a new maze game 
	 */
	public MazeGame(MazeGame maze) {
		state = maze.getState();
		table = maze.getTable();								
		hero = maze.getHero();							
		sword = maze.getSword();			
		dragons = maze.getDragons();
		r = maze.getR();
	}

	/**
	 * Initializes the game
	 */
	public void initialize()
	{
		setState(State.PLAYING);				//Setting Game to play
		hero.clone().heroDeploy(table);					//Deploy Hero in table
		deployDragons(dragons);					//Deploy Dragons in table
		sword.clone().swordDeploy(table);				//Deploy Sword in table		
	}
	/**
	 * Controls number of dragons the user want in the game
	 * 
	 * @param numOfDragons sets number of dragons the user want in the game
	 */
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

	/**
	 * Verifies if exist an empty space
	 * @param x X Element position in table
	 * @param y Y Element position in table
	 * @return true or false
	 */
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
	/**
	 * Confirm if exist more dragons
	 * @param x X dragon position
	 * @param y Y dragon position
	 * @return true or false
	 */
	public boolean noDragon(int x, int y)
	{
		for(int i = 0; i < dragons.size(); i++)
		{
			if(dragons.get(i).getX() == x && dragons.get(i).getY() == y)
				return false;
		}
		return true;
	}

	/**
	 * Sets Game status
	 * @param status sets status game
	 */
	public void setState(State status)
	{
		state = status;
	}

	/**
	 * Gets game state
	 * 
	 * @return game state
	 */
	public State getState(){
		return state;
	}
	/**
	 * Gets hero Object
	 * 
	 * @return hero Object
	 */
	public Hero getHero() {
		return hero;
	}

	/**
	 * Gets sword Object
	 * 
	 * @return sword Object
	 */
	public Sword getSword() {
		return sword;
	}

	/**
	 * Gets dragons in the ArrayList
	 * 
	 * @return dragons in ArrayList
	 */
	public ArrayList<Dragon> getDragons() {
		return dragons;
	}

	/**
	 * Gets random value 
	 * 
	 * @return r random value
	 */
	public Random getR() {
		return r;
	}

	/**
	 * Updates hero movements
	 * 
	 * @param move Direction movement
	 * @return true or false
	 */
	public boolean updateHero(Direction move)
	{
		if(move == Direction.UP)
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
		else if(move == Direction.LEFT)
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
		else if(move == Direction.DOWN)
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
		else if(move == Direction.RIGHT)
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

	/**
	 * Hero movements in the table 
	 * 
	 * @param nPosX sets new hero X position
	 * @param nPosY sets new hero Y position 
	 * @return true or false
	 */
	public boolean heroMove(int nPosX, int nPosY)
	{
		char Elem = table.getElemTable(nPosX, nPosY);
		char Hero = hero.getHeroState();

		/**
		 * Hero gather Sword
		 */
		if(Elem == Table.SWORD)
		{
			table.setElemTable(hero.getX(), hero.getY(), Table.SPACE);
			table.setElemTable(nPosX, nPosY, hero.heroArmed());
			return true;
		}

		/**
		 * Case when Hero Unarmed Confronts Dragon, Dies Horribly
		 */
		else if(Elem == Table.DRAGON && Hero == Table.HERO)
		{
			table.setElemTable(hero.getX(), hero.getY(), Table.SPACE);
			setState(State.LOST);
			return true;
		}

		/**
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

		/**
		 * Sleepy Dragon and Unarmed Hero
		 */
		else if(Elem == SLEEPY && Hero == HERO)
		{
			return false;
		}
		/**
		 * Hero faces Dragon sitting on Sword
		 */
		else if((Elem == DRASWO && Hero == HERO)||
				(Elem == DRASWO && Hero == ARMOR))
		{
			return false;
		}
		/**
		 * Killing Dragon and exit
		 */
		else if(Elem == EXIT && getState() == State.SLAYED)
		{
			table.setElemTable(hero.getX(), hero.getY(), SPACE);
			table.setElemTable(nPosX, nPosY, Hero);
			setState(State.WON);
			return true;
		}
		/**
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

	/**
	 * Updates Dragons movements
	 * 
	 * @param dragon Dragon to be updated
	 * @return true or false
	 */
	public boolean updateDragon(Dragon dragon)
	{
		int move;
		int newPosX = dragon.getX();
		int newPosY = dragon.getY();
		char Dragon = dragon.getDragonState();

		move = r.nextInt(2);

		/**
		 * Movement
		 */
		if(move == 0 && Dragon != SLEEPY)
		{
			/**
			 * Compulsory move
			 */
			while(true)
			{	
				move = r.nextInt(4);
				/**
				 * Upper movement
				 */
				if(move == 0)
				{
					int change = -1;
					if(dragonMove(dragon, newPosX, newPosY + change) == true)
						return true;
				}
				/**
				 * Down movement
				 */
				else if(move == 1)
				{
					int change = +1;
					if(dragonMove(dragon, newPosX, newPosY + change) == true)
						return true;
				}
				/**
				 * Left movement
				 */
				else if(move == 2)
				{
					int change = -1;
					if(dragonMove(dragon, newPosX + change, newPosY) == true)
						return true;
				}
				/**
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
	/**
	 * Dragon movements in the table
	 * 
	 * @param dragon Dragon to move in the game
	 * @param newPosX New Dragon X position
	 * @param newPosY New Dragon Y position
	 * @return true or false
	 */
	public boolean dragonMove(Dragon dragon, int newPosX, int newPosY)
	{
		char Elem = table.getElemTable(newPosX, newPosY);
		char Dragon = dragon.getDragonState();
		/**
		 * For normal Dragon and space movement
		 */
		if(Elem == SPACE && Dragon == DRAGON)
		{
			table.setElemTable(dragon.getX(), dragon.getY(),SPACE);
			table.setElemTable(newPosX, newPosY, DRAGON);
			dragon.setCoord(newPosX, newPosY);
			return true;
		}
		/**
		 * Dragon to Sword movement
		 */
		else if(Elem == SWORD)
		{
			table.setElemTable(dragon.getX(), dragon.getY(),SPACE);
			table.setElemTable(newPosX, newPosY, DRASWO);
			dragon.setCoord(newPosX, newPosY);
			dragon.swordDragon();
			return true;
		}
		/**
		 * Getting out of the Sword
		 */
		else if(Elem == SPACE && Dragon == DRASWO)
		{
			table.setElemTable(dragon.getX(), dragon.getY(),SWORD);
			table.setElemTable(newPosX, newPosY, DRAGON);
			dragon.setCoord(newPosX, newPosY);
			dragon.noSwordDragon();
			return true;
		}
		/**
		 * Dragon killing Hero armed or not
		 */
		else if(Elem == HERO && Dragon == DRAGON || Elem == ARMOR && Dragon == DRAGON)
		{
			table.setElemTable(dragon.getX(), dragon.getY(),SPACE);
			table.setElemTable(newPosX, newPosY, DRAGON);
			dragon.setCoord(newPosX, newPosY);
			setState(State.LOST);
			return true;
		}
		/**
		 * Dragon killing hero and getting out of Sword
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
	/**
	 * Retrieves Elements and sets positions
	 */
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

	/**
	 * Updates Dragons in the ArrayList
	 */
	public void updateDragons()
	{
		for(int i = 0; i < dragons.size(); i++)
		{
			updateDragon(dragons.get(i));
		}
	}

	/**
	 * Deploys ArraysList dragons in the table
	 * 
	 * @param dragons Dragons to be deployed in the maze
	 */
	public void deployDragons(ArrayList<Dragon> dragons)
	{
		for(int i = 0; i < dragons.size(); i++)
		{
			dragons.get(i).dragonDeploy(table);
		}
	}

	/**
	 * Removes dead Dragons from ArrayList
	 * @param x X Dragon position to be removed
	 * @param y Y Dragon position to be removed
	 */
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

	/**
	 * Gets column size
	 * 
	 * @return table height
	 */
	public int getColumn()
	{
		return table.getHeight();
	}

	/**
	 * Gets line size
	 * 
	 * @return table width
	 */
	public int getLine()
	{
		return table.getWidth();
	}
	
	/**
	 * Moves hero left
	 * 
	 * @return true or false
	 */
	public boolean heroMoveLeft()
	{
		return updateHero(Direction.LEFT);
	}
	
	/**
	 * Moves hero right
	 * 
	 * @return true or false
	 */
	public boolean heroMoveRight()
	{
		return updateHero(Direction.RIGHT);
	}
	/**
	 * Moves hero up
	 * 
	 * @return true or false
	 */
	public boolean heroMoveUp()
	{
		return updateHero(Direction.UP);
	}
	/**
	 * Moves hero down
	 * 
	 * @return true or false
	 */
	public boolean heroMoveDown()
	{
		return updateHero(Direction.DOWN);
	}
	/**
	 * Gets hero X position
	 * 
	 * @return X position
	 */
	public int heroGetX()
	{
		return hero.getX();
	}
	/**
	 * Gets hero Y position
	 * 
	 * @return Y position
	 */
	public int heroGetY()
	{
		return hero.getY();
	}
	/**
	 * Gets Dragon X position
	 * 
	 * @return X position
	 */
	public int dragonGetX()
	{
		return dragons.get(0).getX();
	}
	/**
	 * Gets Dragon Y position
	 * 
	 * @return Y position
	 */
	public int dragonGetY()
	{
		return dragons.get(0).getY();
	}
	/**
	 * Gets table
	 * 
	 * @return table
	 */
	public Table getTable()
	{
		return table;
	}
	/**
	 * Gets Dragon at 0 position
	 * 
	 * @return dragon in the first ArrayList position
	 */
	public Dragon getDragon()
	{
		return dragons.get(0);
	}
	/**
	 * Gets Hero state in the game
	 * 
	 * @return Hero state
	 */
	public char getHeroState()
	{
		return hero.getHeroState();
	}
	/**
	 * Gets Dragon state in the game
	 * 
	 * @return Dragon state
	 */
	public char getDragonState()
	{
		return dragons.get(0).getDragonState();
	}

	/**
	 * Converts table to a String Object
	 * 
	 * @return the table as a String Object
	 */
	@Override
	public String toString() 
	{
		return table.toString();
	}

	/**
	 * Gets Hero state in the game
	 * 
	 * @return a MazeGame Object clone
	 */
	public MazeGame clone(){
		return new MazeGame(this);
	}
}
