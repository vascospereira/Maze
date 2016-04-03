package Maze.test;

import static org.junit.Assert.*;
import Maze.logic.*;
import Maze.logic.MazeGame.State;

public class Dragons 
{

	@org.junit.Test (timeout=1000)
	public void DragonToEmptySpace() 
	{
		char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
						{ 'X', ' ', ' ', 'H', 'E' }, 
						{ 'X', ' ', 'X', ' ', 'X' },
						{ 'X', 'S', ' ', 'D', 'X' }, 
						{ 'X', 'X', 'X', 'X', 'X' } };
		
		MazeGame maze = new MazeGame(m1);
		maze.setState(State.PLAYING);

		assertEquals(3,maze.dragonGetX());
		assertEquals(3,maze.dragonGetY());
		assertEquals('D', maze.getDragonState());
		assertEquals(State.PLAYING, maze.getState());


		boolean outcome1 = false, outcome2 = false;
		while(!outcome1 && !outcome2)
		{
			maze.updateDragon(maze.getDragon());
			if(maze.dragonGetX() == 2 && maze.dragonGetY() == 3)
			{
				outcome1 = true;
			}
			else if(maze.dragonGetX() == 3 && maze.dragonGetY() == 2)
			{
				outcome2 = true;
			}
		}
		if(outcome1)
		{
			//System.out.println(i);
			assertEquals(2,maze.dragonGetX());
			assertEquals(3,maze.dragonGetY());
			assertEquals('D', maze.getDragonState());
			assertEquals(State.PLAYING, maze.getState());
		}
		else if(outcome2)
		{
			//System.out.println(i);
			assertEquals(3,maze.dragonGetX());
			assertEquals(2,maze.dragonGetY());
			assertEquals('D', maze.getDragonState());
			assertEquals(State.PLAYING, maze.getState());
		}
	}

	@org.junit.Test (timeout=1000)
	public void dragonToSword() 
	{
		char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
						{ 'X', ' ', ' ', 'H', 'E' }, 
						{ 'X', ' ', 'X', ' ', 'X' },
						{ 'X', 'X', 'S', 'D', 'X' }, 
						{ 'X', 'X', 'X', 'X', 'X' } };
		MazeGame maze = new MazeGame(m1);
		maze.setState(State.PLAYING);

		assertEquals(3,maze.dragonGetX());
		assertEquals(3,maze.dragonGetY());
		assertEquals('D', maze.getDragonState());
		assertEquals(State.PLAYING, maze.getState());


		boolean outcome1 = false;
		while(!outcome1)
		{
			maze.updateDragon(maze.getDragon());
			if(maze.dragonGetX() == 2 && maze.dragonGetY() == 3)
			{
				outcome1 = true;
			}
		}
		if(outcome1)
		{
			assertEquals(2,maze.dragonGetX());
			assertEquals(3,maze.dragonGetY());
			assertEquals('F', maze.getDragonState());
			//System.out.println(i);
		}
	}
	
	@org.junit.Test (timeout=1000)
	public void dragonToHero() 
	{
		char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
				{ 'X', ' ', ' ', ' ', 'E' }, 
				{ 'X', ' ', 'X', 'H', 'X' },
				{ 'X', 'S', 'X', 'D', 'X' }, 
				{ 'X', 'X', 'X', 'X', 'X' } };
		MazeGame maze = new MazeGame(m1);
		maze.setState(State.PLAYING);

		assertEquals(3,maze.dragonGetX());
		assertEquals(3,maze.dragonGetY());
		assertEquals('D', maze.getDragonState());
		assertEquals(State.PLAYING, maze.getState());


		boolean outcome1 = false;
		while(!outcome1)
		{
			maze.updateDragon(maze.getDragon());

			if(maze.dragonGetX() == 3 && maze.dragonGetY() == 2)
			{
				outcome1 = true;
			}
		}
		if(outcome1)
		{
			assertEquals(3,maze.dragonGetX());
			assertEquals(2,maze.dragonGetY());
			assertEquals('D', maze.getDragonState());
			assertEquals(State.LOST, maze.getState());
		}
	}
	@org.junit.Test(timeout = 1000)
	public void dragonToArmor() 
	{
		char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
				{ 'X', ' ', ' ', ' ', 'E' }, 
				{ 'X', ' ', 'X', 'A', 'X' },
				{ 'X', 'S', 'X', 'D', 'X' }, 
				{ 'X', 'X', 'X', 'X', 'X' } };
		MazeGame maze = new MazeGame(m1);
		maze.setState(State.PLAYING);

		assertEquals(3,maze.dragonGetX());
		assertEquals(3,maze.dragonGetY());
		assertEquals('D', maze.getDragonState());
		assertEquals(State.PLAYING, maze.getState());


		boolean outcome1 = false;
		while(!outcome1)
		{
			maze.updateDragon(maze.getDragon());

			if(maze.dragonGetX() == 3 && maze.dragonGetY() == 2)
			{
				outcome1 = true;
			}
		}
		if(outcome1)
		{
			assertEquals(3,maze.dragonGetX());
			assertEquals(2,maze.dragonGetY());
			assertEquals('D', maze.getDragonState());
			assertEquals(State.LOST, maze.getState());
		}
	}
	@org.junit.Test (timeout=1000)
	public void dragonToSleep() 
	{
		char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
				{ 'X', 'H', ' ', ' ', 'E' }, 
				{ 'X', ' ', 'X', ' ', 'X' },
				{ 'X', 'S', 'X', 'D', 'X' }, 
				{ 'X', 'X', 'X', 'X', 'X' } };
		MazeGame maze = new MazeGame(m1);
		maze.setState(State.PLAYING);

		assertEquals(3,maze.dragonGetX());
		assertEquals(3,maze.dragonGetY());
		assertEquals('D', maze.getDragonState());
		assertEquals(State.PLAYING, maze.getState());


		boolean outcome1 = false;
		while(!outcome1)
		{
			maze.updateDragon(maze.getDragon());

			if(maze.getDragonState() == Table.SLEEPY)
			{
				outcome1 = true;
			}
		}
		if(outcome1)
		{
			assertEquals('d', maze.getDragonState());
		}
	}
	@org.junit.Test (timeout=1000)
	public void dragonToSleepAwake() 
	{
		char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
				{ 'X', 'H', ' ', ' ', 'E' }, 
				{ 'X', ' ', 'X', ' ', 'X' },
				{ 'X', 'S', 'X', 'D', 'X' }, 
				{ 'X', 'X', 'X', 'X', 'X' } };
		
		MazeGame maze = new MazeGame(m1);
		maze.setState(State.PLAYING);

		assertEquals(3,maze.dragonGetX());
		assertEquals(3,maze.dragonGetY());
		assertEquals('D', maze.getDragonState());
		assertEquals(State.PLAYING, maze.getState());

		boolean outcome1 = false, outcome2 = false;
		while(!outcome1)
		{
			maze.updateDragon(maze.getDragon());

			if(maze.getDragonState() == Table.SLEEPY)
			{
				outcome1 = true;
			}
		}
		if(outcome1)
		{
			assertEquals('d', maze.getDragonState());
		}
		while(!outcome2)
		{
			maze.updateDragon(maze.getDragon());

			if(maze.getDragonState() == Table.DRAGON)
			{
				outcome2 = true;
			}
		}
		if(outcome2)
		{
			assertEquals('D', maze.getDragonState());
		}
	}
	@org.junit.Test (timeout=1000)
	public void DragonNotMove() 
	{
		char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
				{ 'X', 'H', ' ', ' ', 'E' }, 
				{ 'X', ' ', 'X', ' ', 'X' },
				{ 'X', 'S', 'X', 'D', 'X' }, 
				{ 'X', 'X', 'X', 'X', 'X' } };
		MazeGame maze = new MazeGame(m1);
		maze.setState(State.PLAYING);

		assertEquals(3,maze.dragonGetX());
		assertEquals(3,maze.dragonGetY());
		assertEquals('D', maze.getDragonState());
		assertEquals(State.PLAYING, maze.getState());

		boolean outcome1 = false, outcome2 = false;
		while(!outcome1 && !outcome2)
		{
			outcome1 = false;
			outcome2 = false;
			
			maze.updateDragon(maze.getDragon());
			if(maze.getDragonState() == Table.DRAGON)
			{
				outcome1 = true;
			}
			
			int x = maze.dragonGetX();
			int y = maze.dragonGetY();
			

			if(maze.getDragonState() == Table.DRAGON && maze.dragonGetX() == x && maze.dragonGetY() == y)
			{
				outcome2 = true;
			}
		}
		assertTrue(outcome2 && outcome1);	
	}
	
	@org.junit.Test (timeout=1000)
	public void dragonsTest() 
	{
		char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
						{ 'X', 'H', ' ', ' ', 'E' }, 
						{ 'X', ' ', 'X', ' ', 'X' },
						{ 'X', 'S', 'X', ' ', 'X' }, 
						{ 'X', 'X', 'X', 'X', 'X' } };
		
		MazeGame maze = new MazeGame(m1,2);
		maze.setState(State.PLAYING);
	}
	
	@org.junit.Test
	public void testDragon(){
		char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
						{ 'X', ' ', ' ', ' ', 'E' }, 
						{ 'X', ' ', 'X', ' ', 'X' },
						{ 'X', 'S', 'X', ' ', 'X' }, 
						{ 'X', 'X', 'X', 'X', 'X' } };
		
		Dragon dragon = new Dragon(1,1);
		Table table = new Table(m1);
		dragon.clone().dragonDeploy(table);
		assertEquals("D", dragon.toString());
		assertEquals('D', table.getElemTable(1, 1));
	}
}
