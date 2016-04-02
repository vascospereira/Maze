package Maze.test;

import static org.junit.Assert.*;
import Maze.logic.*;

public class TestTable {

	private char tableToSet[][] = { { 'X', 'X', 'X', 'X' }, 
									{ 'X', ' ', ' ', 'E' }, 
									{ 'X', ' ', 'X', 'X' },
									{ 'X', 'X', 'X', 'X' } };
	
	private char tableToTest[][] = { { 'X', 'X', 'X', 'X', 'X' }, 
									{ 'X', ' ', ' ', ' ', 'E' }, 
									{ 'X', ' ', 'X', ' ', 'X' },
									{ 'X', ' ', 'X', ' ', 'X' }, 
									{ 'X', 'X', 'X', 'X', 'X' } };
	
	@org.junit.Test
	public void testSetTable() 
	{
		Table maze = new Table();
		maze.setTable(tableToSet);
		System.out.println(maze.clone().toString());
		assertEquals(tableToSet.length, maze.clone().getHeight());
	}
	
	@org.junit.Test
	public void testTableDefault() 
	{
		Table maze = new Table();
		int size = maze.getWidth();
		System.out.println(maze.clone().toString());
		assertEquals(size, maze.clone().getWidth());
	}
	
	@org.junit.Test
	public void testTable() 
	{
		int size = tableToTest.length;
		Table maze = new Table(tableToTest);
		maze.setElemTable(1, 1, 'D');
		assertEquals('D', maze.getElemTable(1, 1));
		System.out.println(maze.clone().toString());
		assertEquals(size, maze.clone().getWidth());
	}
	
	@org.junit.Test (timeout=1000)
	public void testDeployElem() 
	{
		boolean outcome1;
		boolean outcome2;
		Table maze = new Table(tableToTest);
		outcome1 = maze.deployElemTable(1, 0, 'D');
		assertFalse(outcome1);
		outcome2 = maze.deployElemTable(1, 1, 'D');
		assertTrue(outcome2);	
	}
	
}
