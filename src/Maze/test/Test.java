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
		Maze Maze  = new Maze();
		Maze.Initialize();
		Maze.HeroMoveRight();
		assertEquals(2,Maze.HeroGetX());
		assertEquals(1,Maze.HeroGetY());
		Maze.HeroMoveLeft();
		assertEquals(1,Maze.HeroGetX());
		assertEquals(1,Maze.HeroGetY());
		Maze.Print();
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
