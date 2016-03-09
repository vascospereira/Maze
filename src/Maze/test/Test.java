package Maze.test;

import static org.junit.Assert.*;
import Maze.logic.*;
import Maze.logic.Maze.State;

public class Test {

	char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' }, 
					{ 'X', ' ', ' ', 'H', 'E' }, 
					{ 'X', ' ', 'X', 'D', 'X' },
					{ 'X', 'S', ' ', ' ', 'X' }, 
					{ 'X', 'X', 'X', 'X', 'X' } };
	
	char[][] m2 = { { 'X', 'X', 'X', 'X', 'X' }, 
					{ 'X', ' ', 'S', 'H', 'E' }, 
					{ 'X', ' ', 'X', 'D', 'X' },
					{ 'X', ' ', ' ', ' ', 'X' }, 
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
	}

	@org.junit.Test
	public void testMoveHeroToSword() 
	{
		Maze maze = new Maze(m2);
		maze.initialize();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.HERO, maze.getHeroState());
		maze.heroMoveLeft();
		assertEquals(2,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.ARMOR, maze.getHeroState());
		
	}

	@org.junit.Test
	public void testUnarmedHeroDragon() 
	{
		Maze maze = new Maze(m2);
		maze.initialize();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.HERO, maze.getHeroState());
		assertEquals(State.PLAYING, maze.getState());
		maze.heroMoveDown();
		assertEquals(3,maze.heroGetX());
		assertEquals(2,maze.heroGetY());
		assertEquals(State.LOST, maze.getState());
	}

	@org.junit.Test
	public void testArmedHeroDragon() 
	{
		Maze maze = new Maze(m2);
		maze.initialize();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.HERO, maze.getHeroState());
		assertEquals(State.PLAYING, maze.getState());
		maze.heroMoveLeft();
		assertEquals(2,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.ARMOR, maze.getHeroState());
		maze.heroMoveRight();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.ARMOR, maze.getHeroState());
		maze.heroMoveDown();
		assertEquals(3,maze.heroGetX());
		assertEquals(2,maze.heroGetY());
		assertEquals(State.SLAYED, maze.getState());
	}

	@org.junit.Test
	public void testDragonExitWithSword() 
	{
		Maze maze = new Maze(m2);
		maze.initialize();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.HERO, maze.getHeroState());
		assertEquals(State.PLAYING, maze.getState());
		maze.heroMoveLeft();
		assertEquals(2,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.ARMOR, maze.getHeroState());
		assertEquals(State.PLAYING, maze.getState());
		maze.heroMoveRight();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.ARMOR, maze.getHeroState());
		assertEquals(State.PLAYING, maze.getState());
		maze.heroMoveDown();
		assertEquals(3,maze.heroGetX());
		assertEquals(2,maze.heroGetY());
		assertEquals(State.SLAYED, maze.getState());
		assertEquals(Table.ARMOR, maze.getHeroState());
		maze.heroMoveUp();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.ARMOR, maze.getHeroState());
		assertEquals(State.SLAYED, maze.getState());
		maze.heroMoveRight();
		assertEquals(4,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.ARMOR, maze.getHeroState());
		assertEquals(State.WON, maze.getState());
	}

	@org.junit.Test
	public void testDragonExitSword() 
	{
		Maze maze = new Maze(m2);
		maze.initialize();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.HERO, maze.getHeroState());
		assertEquals(State.PLAYING, maze.getState());
		maze.heroMoveRight();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.HERO, maze.getHeroState());
		assertEquals(State.PLAYING, maze.getState());
	}

	@org.junit.Test
	public void testArmedDragonExitWithDragonLive() 
	{
		Maze maze = new Maze(m2);
		maze.initialize();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.HERO, maze.getHeroState());
		assertEquals(State.PLAYING, maze.getState());
		maze.heroMoveLeft();
		assertEquals(2,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.ARMOR, maze.getHeroState());
		maze.heroMoveRight();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.ARMOR, maze.getHeroState());
		maze.heroMoveRight();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals(Table.ARMOR, maze.getHeroState());
		assertEquals(State.PLAYING, maze.getState());
		
	}
}
