package Maze.gui;

import Maze.cli.Game.Direction;

import Maze.gui.Window;
import Maze.gui.Window.DragonState;
import Maze.logic.*;
import Maze.logic.MazeGame.State;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * 
 * WindowFrame Class extends JPanel
 *
 */
@SuppressWarnings("serial")
public class WindowFrame extends JPanel implements KeyListener, MouseListener {
	private BufferedImage floor;
	private BufferedImage wall;
	private BufferedImage wallup;
	private BufferedImage hero;
	private BufferedImage dragon;
	private BufferedImage sleepy;
	private BufferedImage armor;
	private BufferedImage sword;
	private BufferedImage exit;

	/**
	 * Create WindowFrame
	 */
	public WindowFrame() {
		addKeyListener(this);
		addMouseListener(this);
		try {
			hero = ImageIO.read(new File("hero.png"));
			floor = ImageIO.read(new File("floor.png"));
			wall = ImageIO.read(new File("wall.png"));
			dragon = ImageIO.read(new File("dragon.png"));
			sleepy = ImageIO.read(new File("sleepy.png"));
			armor = ImageIO.read(new File("armored.png"));
			sword = ImageIO.read(new File("sword.png"));
			exit = ImageIO.read(new File("exit.png"));
			wallup = ImageIO.read(new File("wallup.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * @Override paintComponent()
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Window.maze == null)
			return;

		MazeGame game = Window.maze;

		int size = this.getWidth() / game.getTable().getHeight();
		int n = game.getTable().getHeight();

		int x = 0;
		int y = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i == n - 1) || (j > 0 && j < n - 1 && i == 0)) {
					if (game.getTable().getElemTable(j, i) == Table.EXIT) {
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
						g.drawImage(exit, x, y, x + size, y + size, 0, 0, exit.getWidth(), exit.getHeight(), null);

					} else if (game.getTable().getElemTable(j, i) == Table.ARMOR) {
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
						g.drawImage(armor, x, y, x + size, y + size, 0, 0, armor.getWidth(), armor.getHeight(), null);
					} else {
						if (i == 0) {
							if (game.getTable().getElemTable(j, i + 1) != Table.WALL)
								g.drawImage(wallup, x, y, x + size, y + size, 0, 0, wallup.getWidth(),
										wallup.getHeight(), null);
							else
								g.drawImage(wall, x, y, x + size, y + size, 0, 0, wall.getWidth(), wall.getHeight(),
										null);
						} else
							g.drawImage(wallup, x, y, x + size, y + size, 0, 0, wallup.getWidth(), wallup.getHeight(),
									null);

					}
				}

				else if (j == n - 1 || j == 0) {
					if (game.getTable().getElemTable(j, i) == Table.EXIT) {
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
						g.drawImage(exit, x, y, x + size, y + size, 0, 0, exit.getWidth(), exit.getHeight(), null);

					} else if (game.getTable().getElemTable(j, i) == Table.ARMOR) {
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
						g.drawImage(armor, x, y, x + size, y + size, 0, 0, armor.getWidth(), armor.getHeight(), null);
					} else
						g.drawImage(wall, x, y, x + size, y + size, 0, 0, wall.getWidth(), wall.getHeight(), null);
				} else {
					if (game.getTable().getElemTable(j, i) == Table.SPACE)
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
					else if (game.getTable().getElemTable(j, i) == Table.WALL) {
						if (game.getTable().getElemTable(j, i + 1) != Table.WALL)
							g.drawImage(wallup, x, y, x + size, y + size, 0, 0, wallup.getWidth(), wallup.getHeight(),
									null);
						else
							g.drawImage(wall, x, y, x + size, y + size, 0, 0, wall.getWidth(), wall.getHeight(), null);

					} else if (game.getTable().getElemTable(j, i) == Table.HERO) {
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
						g.drawImage(hero, x, y, x + size, y + size, 0, 0, hero.getWidth(), hero.getHeight(), null);
					} else if (game.getTable().getElemTable(j, i) == Table.ARMOR) {
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
						g.drawImage(armor, x, y, x + size, y + size, 0, 0, armor.getWidth(), armor.getHeight(), null);
					} else if (game.getTable().getElemTable(j, i) == Table.EXIT) {
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
						g.drawImage(exit, x, y, x + size, y + size, 0, 0, exit.getWidth(), exit.getHeight(), null);
					} else if (game.getTable().getElemTable(j, i) == Table.DRAGON) {
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
						g.drawImage(dragon, x, y, x + size, y + size, 0, 0, dragon.getWidth(), dragon.getHeight(),
								null);
					} else if (game.getTable().getElemTable(j, i) == Table.SWORD) {
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
						g.drawImage(sword, x, y, x + size, y + size, 0, 0, sword.getWidth(), sword.getHeight(), null);
					} else if (game.getTable().getElemTable(j, i) == Table.SLEEPY) {
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
						g.drawImage(sleepy, x, y, x + size, y + size, 0, 0, sleepy.getWidth(), sleepy.getHeight(),
								null);
					} else if (game.getTable().getElemTable(j, i) == Table.DRASWO) {
						g.drawImage(floor, x, y, x + size, y + size, 0, 0, floor.getWidth(), floor.getHeight(), null);
						g.drawImage(dragon, x, y, x + size, y + size, 0, 0, dragon.getWidth(), dragon.getHeight(),
								null);
					}
				}
				x += size;
			}
			x = 0;
			y += size;
		}
		
		

	}
	/**
	 * @Override keyPressed()
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (Window.maze.getState() != State.LOST && Window.maze.getState() != State.WON) {
				Window.maze.updateHero(Direction.LEFT);
				if (Window.dragonState == DragonState.MOVING) {
					Window.maze.updateDragons();
				}
				repaint();
			}
			break;
		case KeyEvent.VK_A:
			if (Window.maze.getState() != State.LOST && Window.maze.getState() != State.WON) {
				Window.maze.updateHero(Direction.LEFT);
				if (Window.dragonState == DragonState.MOVING) {
					Window.maze.updateDragons();
				}
				repaint();
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (Window.maze.getState() != State.LOST && Window.maze.getState() != State.WON) {
				Window.maze.updateHero(Direction.RIGHT);
				if (Window.dragonState == DragonState.MOVING) {
					Window.maze.updateDragons();
				}
				repaint();
			}
			break;
		case KeyEvent.VK_D:
			if (Window.maze.getState() != State.LOST && Window.maze.getState() != State.WON) {
				Window.maze.updateHero(Direction.RIGHT);
				if (Window.dragonState == DragonState.MOVING) {
					Window.maze.updateDragons();
				}
				repaint();
			}
			break;

		case KeyEvent.VK_UP:
			if (Window.maze.getState() != State.LOST && Window.maze.getState() != State.WON) {
				Window.maze.updateHero(Direction.UP);
				if (Window.dragonState == DragonState.MOVING) {
					Window.maze.updateDragons();
				}
				repaint();
			}
			break;
		case KeyEvent.VK_W:
			if (Window.maze.getState() != State.LOST && Window.maze.getState() != State.WON) {
				Window.maze.updateHero(Direction.UP);
				if (Window.dragonState == DragonState.MOVING) {
					Window.maze.updateDragons();
				}
				repaint();
			}
			break;
		case KeyEvent.VK_DOWN:
			if (Window.maze.getState() != State.LOST && Window.maze.getState() != State.WON) {
				Window.maze.updateHero(Direction.DOWN);
				if (Window.dragonState == DragonState.MOVING) {
					Window.maze.updateDragons();
				}
				repaint();
			}
			break;
		case KeyEvent.VK_S:
			if (Window.maze.getState() != State.LOST && Window.maze.getState() != State.WON) {
				Window.maze.updateHero(Direction.DOWN);
				if (Window.dragonState == DragonState.MOVING) {
					Window.maze.updateDragons();
				}
				repaint();
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.requestFocus();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	/**
	 * @Override mousePressed
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		this.requestFocus();

	}
	/**
	 * @Override mouseReleased
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
