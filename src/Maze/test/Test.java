package Maze.test;

import static org.junit.Assert.*;
import Maze.logic.*;

public class Test {

	char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
					{ 'X', ' ', ' ', 'H', 'E' }, 
					{ 'X', ' ', 'X', 'D', 'X' },
					{ 'X', 'S', ' ', ' ', 'X' }, 
					{ 'X', 'X', 'X', 'X', 'X' } };
	
	
	@org.junit.Test
	public void testMoveHeroToFreeCell() 
	{
		Maze maze = new Maze(m1);
		maze.initialize();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		maze.heroMoveLeft();
		assertEquals(2,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		maze.print();
	}

	@org.junit.Test
	public void testMoveHeroAgainstWall() 
	{
		Maze maze = new Maze(m1);
		maze.initialize();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		maze.heroMoveUp();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		maze.print();
	}
	
	@org.junit.Test
	public void testMoveHeroToSword() 
	{
		Maze maze = new Maze(m1);
		maze.initialize();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		maze.heroMoveUp();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		maze.print();
	}
	
	@org.junit.Test
	public void testUnarmedHeroDragon() 
	{
		
	}
	
	@org.junit.Test
	public void testArmedHeroDragon() 
	{
		
	}

	@org.junit.Test
	public void testDragonExitWithSword() 
	{
		
	}
	
	@org.junit.Test
	public void testDragonExitSword() 
	{
		
	}
	
	@org.junit.Test
	public void testArmedDragonExitWithDragonLive() 
	{
		
	}
}
