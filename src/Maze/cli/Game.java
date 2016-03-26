package Maze.cli;

import java.util.Scanner;
import Maze.logic.MazeGame;
import Maze.logic.MazeBuilder;
import Maze.logic.MazeGame.State;
import Maze.logic.Table;

public class Game {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int mazeSize = 1;
		int numOfDragons = 1;
		/*
		 * Choose type of Table
		 */
		do {
			System.out.println("Maze size must be (ODD number >= 5)\n " + "or 0 (zero) for default Maze.");
			if (s.hasNextInt()) {
				mazeSize = s.nextInt();
			} else
				s.next();

		} while (mazeSize != 0 && !(mazeSize % 2 == 1 && mazeSize >= 5));
		/*
		 * Number of dragons
		 */
		if (mazeSize != 0) {
			do {
				System.out.println("Number of Dragons <max of 3>? ");
				if (s.hasNextInt()) {
					numOfDragons = s.nextInt();
				} else
					s.next();
			} while (numOfDragons > 3);
		}

		/*
		 * Start Maze
		 */
		MazeGame maze;

		if (mazeSize == 0) {
			maze = new MazeGame(1);
			maze.initialize();
			printTable(maze.getTable());
		} else {
			maze = new MazeGame(MazeBuilder.generateMaze(mazeSize), numOfDragons);
			maze.initialize();
			printTable(maze.getTable());
		}

		char c = s.next().charAt(0);
		String p = convert(c);

		while (p != "Close" && (maze.getState() == State.PLAYING || maze.getState() == State.SLAYED)) {
			/*
			 *  Updating the game accordingly with scanner, and printing Game
			 */
			maze.updateHero(p);
			if (maze.getState() == State.PLAYING) {
				maze.updateDragons();
			}

			printTable(maze.getTable());

			/*
			 * Game State
			 */
			if (maze.getState() == State.LOST) {
				System.out.println("You Lost!");
				break;
			}
			if (maze.getState() == State.WON) {
				System.out.println("You Win!");
				break;
			}

			c = s.next().charAt(0);
			p = convert(c);
		}

		s.close();
		return;
	}

	private static String convert(char c) {
		if (c == 'f' || c == 'F')
			return "Close";
		else if (c == 'W' || c == 'w')
			return "Up";
		else if (c == 'A' || c == 'a')
			return "Left";
		else if (c == 'S' || c == 's')
			return "Down";
		else if (c == 'D' || c == 'd')
			return "Rigth";
		else
			return "";

	}

	private static void printTable(Table table) {
		System.out.print(table.toString());
	}

}