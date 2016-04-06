package Maze.cli;

import java.util.Scanner;
import Maze.logic.MazeGame;
import Maze.logic.MazeBuilder;
import Maze.logic.MazeGame.State;
import Maze.logic.Table;
/**
 * Maze command line Interface
 *
 */
public class Game {
/**
 * 
 * Direction Enum type
 *
 */
	public enum Direction {UP, DOWN, RIGHT, LEFT, STOP};
	static Direction move;
	/**
	 * Main functions on the command line interface
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int mazeSize = 1;
		int numOfDragons = 1;
		
		do {
			System.out.println("Maze size must be (ODD number >= 5)\n" + "or 0 (zero) for default Maze.");
			if (s.hasNextInt()) {
				mazeSize = s.nextInt();
			} else
				s.next();
		} while (mazeSize != 0 && !(mazeSize % 2 == 1 && mazeSize >= 5));
		
		do {
			System.out.println("Number of Dragons <max of 3> ");
			if (s.hasNextInt()) {
				numOfDragons = s.nextInt();
			} else
				s.next();
		} while (numOfDragons > 3);

		MazeGame maze;
		
		if (mazeSize == 0) {
			maze = new MazeGame(numOfDragons);
			maze.initialize();
			printTable(maze.getTable());
		} else {
			maze = new MazeGame(MazeBuilder.generateMaze(mazeSize), numOfDragons);
			maze.initialize();
			printTable(maze.getTable());
		}

		char playerInput = s.next().charAt(0);
		convert(playerInput);
		
		while (move != Direction.STOP && (maze.getState() == State.PLAYING || maze.getState() == State.SLAYED)) {
		
			maze.updateHero(move);
			if (maze.getState() == State.PLAYING) {
				maze.updateDragons();
			}

			printTable(maze.getTable());
			
			if (maze.getState() == State.LOST) {
				System.out.println("You Lost!");
				break;
			}
			else if (maze.getState() == State.WON) {
				System.out.println("You Win!");
				break;
			}
			
			playerInput = s.next().charAt(0);
			convert(playerInput);
		}

		s.close();
		return;
	}
	/**
	 * Convert characters to input Directions
	 * @param input
	 */
	private static void convert(char input) {
		if (input == 'W' || input == 'w')
			move = Direction.UP;
		else if (input == 'A' || input == 'a')
			move = Direction.LEFT;
		else if (input == 'S' || input == 's')
			move = Direction.DOWN;
		else if (input == 'D' || input == 'd')
			move = Direction.RIGHT;
		else if (input == 'f' || input == 'F')
			move = Direction.STOP;
		
	}
	/**
	 * Print Table function
	 * @param table
	 */
	private static void printTable(Table table) {
		System.out.print(table.toString());
	}

}