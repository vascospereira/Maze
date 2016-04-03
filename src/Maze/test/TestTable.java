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
		assertEquals(tableToSet.length, maze.clone().getHeight());
	}
	
	@org.junit.Test
	public void testTableDefault() 
	{
		Table maze = new Table();
		int size = maze.getWidth();
		assertEquals(size, maze.clone().getWidth());
	}
	
	@org.junit.Test
	public void testTable() 
	{
		int size = tableToTest.length;
		Table maze = new Table(tableToTest);
		maze.setElemTable(1, 1, 'D');
		maze.setElemTable(1, 3, 'S');
		assertEquals('S', maze.getElemTable(1, 3));
		
		String table = str();
		assertTrue(table.equals(maze.toString()));
		assertEquals('D', maze.getElemTable(1, 1));
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
	
	private String str() {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < tableToTest.length; y++) {
			for (int x = 0; x < tableToTest.length; x++) {
				sb.append(tableToTest[y][x] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
