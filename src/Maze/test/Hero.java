package Maze.test;

import static org.junit.Assert.*;
import Maze.logic.*;
import Maze.logic.MazeGame.State;

public class Hero {

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
		MazeGame maze = new MazeGame(m1);
		maze.clone();
		assertEquals(3,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		maze.heroMoveLeft();
		assertEquals(2,maze.heroGetX());
		assertEquals(1,maze.heroGetY());
		assertEquals("H",maze.getHero().toString());
	}

	@org.junit.Test
	public void testMoveHeroAgainstWall() 
	{
		MazeGame maze = new MazeGame(m1);
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
		MazeGame maze = new MazeGame(m2);
		Sword sword = new Sword(1,1);
		Table table = new Table(m2);
		sword.swordDeploy(table);
		assertEquals("S", sword.toString());
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
		MazeGame maze = new MazeGame(m2);
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
		MazeGame maze = new MazeGame(m2);
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
		MazeGame maze = new MazeGame(m2);
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
		MazeGame maze = new MazeGame(m2);
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
		MazeGame maze = new MazeGame(m2);
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
