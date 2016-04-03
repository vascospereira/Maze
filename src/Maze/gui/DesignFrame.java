package Maze.gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Maze.logic.Table;

@SuppressWarnings("serial")
public class DesignFrame extends JPanel implements  MouseListener, MouseMotionListener
{

	private BufferedImage floor;
	private BufferedImage wall;
	private BufferedImage wallup;
	private BufferedImage hero;
	private BufferedImage dragon;
	private BufferedImage sleepy;
	private BufferedImage armor;
	private BufferedImage sword;
	private BufferedImage exit;

	static char[][] table;
	private int size;


	public DesignFrame(int size)
	{
		filltable(size);
		this.size = size;
		addMouseListener(this);
		addMouseMotionListener(this);
		try
		{
			hero =  ImageIO.read(new File("hero.png"));
			floor =  ImageIO.read(new File("floor.png"));
			wall =  ImageIO.read(new File("wall.png"));
			dragon =  ImageIO.read(new File("dragon.png"));
			sleepy =  ImageIO.read(new File("sleepy.png"));
			armor =  ImageIO.read(new File("armored.png"));
			sword =  ImageIO.read(new File("sword.png"));
			exit =  ImageIO.read(new File("exit.png"));
			wallup =  ImageIO.read(new File("wallup.png"));

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}

	public void printTable()
	{
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < table.length; y++) {
			for (int x = 0; x < table.length; x++) {
				sb.append(table[y][x] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public void filltable(int size)
	{
		table = new char[size][size];
		for(int j = 0; j < size; j++)
		{
			for(int i = 0; i < size; i++)
			{
				if((i==0) || (j==0) || (i==size-1) || (j == size-1))
				{
					table[j][i] = Table.WALL;
				}
				else
				{
					table[j][i] = Table.SPACE;
				}
			}
		}
		repaint();
	}

	public void findreplace(char c)
	{

		for(int j = 0; j < size; j++)
		{
			for(int i = 0; i < size; i++)
			{
				if(table[j][i] == c)
					table[j][i] = Table.SPACE;
			}
		}
		repaint();
	}

	public void assertable()
	{
		int y = 0;

		for(int x = 0; x < size; x++)
		{
			if(table[y][x] != Table.WALL && table[y][x] != Table.EXIT)
				table[y][x] = Table.WALL;
		}

		y = size-1;

		for(int x = 0; x < size; x++)
		{
			if(table[y][x] != Table.WALL && table[y][x] != Table.EXIT)
				table[y][x] = Table.WALL;
		}

		int x = 0;

		for(y = 0; y < size; y++)
		{
			if(table[y][x] != Table.WALL && table[y][x] != Table.EXIT)
				table[y][x] = Table.WALL;
		}

		x = size-1;

		for(y = 0; y < size; y++)
		{
			if(table[y][x] != Table.WALL && table[y][x] != Table.EXIT)
				table[y][x] = Table.WALL;
		}

		repaint();
	}



	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		int size = this.getWidth() / table.length;
		int n = table.length;

		int x = 0;
		int y = 0;


		for(int i = 0; i < n; i++ )
		{
			for(int j = 0; j < n; j++)
			{	
				if((i == n-1) || (j > 0  && j < n-1 && i == 0))
				{
					if(table[i][j] == Table.EXIT)
					{
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
						g.drawImage(exit, x, y, x+size, y+size, 0 , 0,  exit.getWidth(),exit.getHeight(), null);

					}
					else if(table[i][j] == Table.ARMOR)
					{
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
						g.drawImage(armor, x, y, x+size, y+size, 0 , 0,  armor.getWidth(),armor.getHeight(), null);
					}
					else
					{
						if(i == 0)
						{
							if(table[i+1][j] != Table.WALL)
								g.drawImage(wallup, x, y, x+size, y+size, 0 , 0,  wallup.getWidth(),wallup.getHeight(), null);
							else
								g.drawImage(wall, x, y, x+size, y+size, 0 , 0,  wall.getWidth(),wall.getHeight(), null);
						}
						else
							g.drawImage(wallup, x, y, x+size, y+size, 0 , 0,  wallup.getWidth(),wallup.getHeight(), null);

					}
				}

				else if(j == n-1 || j == 0)
				{
					if(table[i][j] == Table.EXIT)
					{
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
						g.drawImage(exit, x, y, x+size, y+size, 0 , 0,  exit.getWidth(),exit.getHeight(), null);

					}
					else if(table[i][j] == Table.ARMOR)
					{
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
						g.drawImage(armor, x, y, x+size, y+size, 0 , 0,  armor.getWidth(),armor.getHeight(), null);
					}
					else
						g.drawImage(wall, x, y, x+size, y+size, 0 , 0,  wall.getWidth(),wall.getHeight(), null);
				}
				else
				{
					if(table[i][j] == Table.SPACE)
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
					else if(table[i][j] == Table.WALL)
					{
						if(table[i+1][j] != Table.WALL)
							g.drawImage(wallup, x, y, x+size, y+size, 0 , 0,  wallup.getWidth(),wallup.getHeight(), null);
						else
							g.drawImage(wall, x, y, x+size, y+size, 0 , 0,  wall.getWidth(),wall.getHeight(), null);

					}
					else if(table[i][j] == Table.HERO)
					{
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
						g.drawImage(hero, x, y, x+size, y+size, 0 , 0,  hero.getWidth(),hero.getHeight(), null);
					}
					else if(table[i][j] == Table.ARMOR)
					{
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
						g.drawImage(armor, x, y, x+size, y+size, 0 , 0,  armor.getWidth(),armor.getHeight(), null);
					}
					else if(table[i][j] == Table.EXIT)
					{
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
						g.drawImage(exit, x, y, x+size, y+size, 0 , 0,  exit.getWidth(),exit.getHeight(), null);
					}
					else if(table[i][j] == Table.DRAGON)
					{
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
						g.drawImage(dragon, x, y, x+size, y+size, 0 , 0,  dragon.getWidth(),dragon.getHeight(), null);
					}
					else if(table[i][j] == Table.SWORD)
					{
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
						g.drawImage(sword, x, y, x+size, y+size, 0 , 0,  sword.getWidth(),sword.getHeight(), null);
					}
					else if(table[i][j] == Table.SLEEPY)
					{
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
						g.drawImage(sleepy, x, y, x+size, y+size, 0 , 0,  sleepy.getWidth(),sleepy.getHeight(), null);
					}
					else if(table[i][j] == Table.DRASWO)
					{
						g.drawImage(floor, x, y, x+size, y+size, 0 , 0,  floor.getWidth(),floor.getHeight(), null);
						g.drawImage(dragon, x, y, x+size, y+size, 0 , 0,  dragon.getWidth(),dragon.getHeight(), null);
					}
				}
				x+=size;	
			}
			x = 0;
			y+=size;
		}


	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int space = this.getHeight()/size;
		int i = e.getX()/space;
		int j = e.getY()/space;
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			if(Design.status == Design.ObjectState.HERO)
			{
				findreplace(Table.HERO);
				table[j][i]=Table.HERO;
				assertable();
			}
			else if(Design.status == Design.ObjectState.DRAGON)
			{
				table[j][i]=Table.DRAGON;
				assertable();
			}
			else if(Design.status == Design.ObjectState.SWORD)
			{
				findreplace(Table.SWORD);
				table[j][i]=Table.SWORD;
				assertable();
			}
			else if(Design.status == Design.ObjectState.WALL)
			{
				table[j][i]=Table.WALL;
			}
			else if(Design.status == Design.ObjectState.FLOOR)
			{
				table[j][i]=Table.SPACE;
				assertable();
			}
			else if(Design.status == Design.ObjectState.EXIT)
			{
				if((j==0) || (j==size-1) || (i==0) || (i == size-1))
				{
					findreplace(Table.EXIT);
					table[j][i]=Table.EXIT;
				}

			}
			else{}
		}
		else if(e.getButton() == MouseEvent.BUTTON3)
		{
			table[j][i]=Table.SPACE;
		}
		else{}
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		int space = this.getHeight()/size;
		int i = e.getX()/space;
		int j = e.getY()/space;
		if(Design.status == Design.ObjectState.WALL && (e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) == MouseEvent.BUTTON1_DOWN_MASK)
			table[j][i]=Table.WALL;
		repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
