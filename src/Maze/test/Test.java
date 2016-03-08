package Maze.test;

import static org.junit.Assert.*;
import Maze.logic.*;

public class Test {

	@org.junit.Test
	public void test() 
	{
		Maze Maze  = new Maze();
		Maze.Initialize();
		Maze.UpdateHero('D');
		assertEquals(2,Maze.HeroGetX());
		assertEquals(1,Maze.HeroGetY());
		Maze.UpdateHero('A');
		assertEquals(1,Maze.HeroGetX());
		assertEquals(1,Maze.HeroGetY());
		Maze.Print();
	}

}
