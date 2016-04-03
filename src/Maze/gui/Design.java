package Maze.gui;
import javax.swing.JDialog;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Maze.logic.Table;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * Design Class
 *
 */
@SuppressWarnings("serial")
public class Design extends JDialog{
	
	/**
	 * Space for Components
	 */

	private JButton btnHero;
	private JButton btnDragon;
	private JButton btnSword;
	private JButton btnWall;
	private JButton btnFloor;
	private JButton btnExit;
	private JButton btnGenerate;
	private JButton btnClose;
	private JPanel EditorPanel;

	static enum ObjectState {NULL, HERO, DRAGON, SWORD, WALL, FLOOR, EXIT}
	static ObjectState status = ObjectState.NULL;

	boolean valid = false;

	/**
	 * To check if it is possible to create Game from Design
	 * @return true or false
	 */
	public boolean isValid()
	{
		return valid;
	}
	/**
	 * Returns the Validity of Maze of the new Created Maze
	 * @param maze
	 * @return true or false
	 */
	public boolean isMazeValid(char[][] maze)
	{
		int hero = 0;
		int dragons = 0;
		int exit = 0;
		int sword = 0;

		for(int j = 0; j < maze.length; j++)
		{
			for(int i = 0; i < maze.length; i++)
			{
				if(maze[j][i] == Table.DRAGON)
				{
					dragons++;
				}
				else if(maze[j][i] == Table.HERO)
				{
					hero++;
				}
				else if(maze[j][i] == Table.SWORD)
				{
					sword++;
				}else if(maze[j][i] == Table.EXIT)
				{
					exit++;
				}
			}
		}

		if(dragons < 1 || hero < 1 || exit < 1 || sword < 1)
		{
			return false;
		}
		else
			return true;
	}

	/**
	 * Creating a Design Maze 
	 * @param size
	 */
	public Design(int size)
	{
		super((java.awt.Frame) null, true);
		setResizable(false);
		setTitle("Design Table");
		setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 517, 635);
		getContentPane().setLayout(null);
		EditorPanel = new DesignFrame(size);
		EditorPanel.setBounds(19, 119, 471, 471);
		getContentPane().add(EditorPanel);
		btnHero = new JButton("Hero");
		btnHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				status = ObjectState.HERO;
			}
		});
		btnHero.setBounds(19, 11, 105, 23);
		getContentPane().add(btnHero);

		btnDragon = new JButton("Dragon");
		btnDragon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				status = ObjectState.DRAGON;
			}
		});
		btnDragon.setBounds(19, 45, 105, 23);
		getContentPane().add(btnDragon);

		btnSword = new JButton("Sword");
		btnSword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				status = ObjectState.SWORD;
			}
		});
		btnSword.setBounds(19, 79, 105, 23);
		getContentPane().add(btnSword);

		btnWall = new JButton("Wall");
		btnWall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				status = ObjectState.WALL;
			}
		});
		btnWall.setBounds(134, 11, 104, 23);
		getContentPane().add(btnWall);

		btnFloor = new JButton("Floor");
		btnFloor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				status = ObjectState.FLOOR;
			}
		});
		btnFloor.setBounds(134, 45, 104, 23);
		getContentPane().add(btnFloor);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				status = ObjectState.EXIT;
			}
		});
		btnExit.setBounds(134, 79, 104, 23);
		getContentPane().add(btnExit);

		btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(isMazeValid(DesignFrame.table))
				{
					valid = true;
					status = ObjectState.NULL;
					SwingUtilities.getWindowAncestor(Design.this).dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Must have at least one Hero, one Dragon, one Sword and one Exit", "Invalid Maze", JOptionPane.WARNING_MESSAGE);	
				
				}
			}
		});
		btnGenerate.setBounds(262, 11, 228, 40);
		getContentPane().add(btnGenerate);

		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				valid = false;
				status = ObjectState.NULL;
				SwingUtilities.getWindowAncestor(Design.this).dispose();

			}
		});
		btnClose.setBounds(262, 62, 229, 40);
		getContentPane().add(btnClose);
	}
}
