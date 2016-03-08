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
		maze.Initialize();
		assertEquals(3,maze.HeroGetX());
		assertEquals(1,maze.HeroGetY());
		maze.HeroMoveLeft();
		assertEquals(2,maze.HeroGetX());
		assertEquals(1,maze.HeroGetY());
		maze.Print();
	}

	@org.junit.Test
	public void testMoveHeroAgainstWall() 
	{
		
	}
	
	@org.junit.Test
	public void testMoveHeroToSword() 
	{

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
