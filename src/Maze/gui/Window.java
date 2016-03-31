package Maze.gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;

import Maze.cli.Game.Direction;
import Maze.logic.*;
import Maze.logic.MazeGame.State;

public class Window {

	private JFrame Window;
	private JTextField NofDragonsField;
	private JTextField DimensionsField;

	private JLabel NofDragonsLabel;
	private JLabel DimensionsLabel;
	private JLabel DragonTypeLabel;
	private JComboBox<String> DragonTypeCombo;
	private JButton GenerateButton;
	private JButton CloseButton;
	private JButton UpButton;
	private JButton LeftButton;
	private JButton	RigthButton;
	private JButton DownButton;
	private JLabel StateLabel;
	private JTextArea MazeArea;

	/**
	 * Place for the game components 
	 */

	private MazeGame maze;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.Window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Window = new JFrame();
		Window.setTitle("Mazes & Dragons");
		Window.setResizable(false);
		Window.setBounds(100, 100, 516, 374);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.getContentPane().setLayout(null);

		NofDragonsLabel = new JLabel("Number of Dragons:");
		NofDragonsLabel.setBounds(19, 45, 117, 22);
		Window.getContentPane().add(NofDragonsLabel);

		NofDragonsField = new JTextField();
		NofDragonsField.setText("1");
		NofDragonsField.setBounds(146, 46, 130, 20);
		Window.getContentPane().add(NofDragonsField);
		NofDragonsField.setColumns(10);

		DimensionsLabel = new JLabel("Maze Dimensions: ");
		DimensionsLabel.setBounds(19, 18, 117, 14);
		Window.getContentPane().add(DimensionsLabel);

		DimensionsField = new JTextField();
		DimensionsField.setText("11");
		DimensionsField.setBounds(146, 15, 130, 20);
		Window.getContentPane().add(DimensionsField);
		DimensionsField.setColumns(10);

		DragonTypeLabel = new JLabel("Dragon Type");
		DragonTypeLabel.setBounds(19, 78, 98, 14);
		Window.getContentPane().add(DragonTypeLabel);

		DragonTypeCombo = new JComboBox<String>();
		DragonTypeCombo.setBounds(146, 75, 130, 20);
		Window.getContentPane().add(DragonTypeCombo);

		DragonTypeCombo.addItem("In Movement");
		DragonTypeCombo.addItem("Static");

		GenerateButton = new JButton("Generate Maze");
		GenerateButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				disableInterface();
				MazeArea.setText("");
				StateLabel.setForeground(Color.BLACK);

				int dim;
				dim = Integer.parseInt(DimensionsField.getText());

				int nodrag;
				nodrag = Integer.parseInt(NofDragonsField.getText());

				if((dim == 0) || (dim >= 11 && nodrag >= 1 && nodrag <= 3 && dim % 2 == 1))
				{
					if(dim == 0)
					{
						maze = new MazeGame(1);
						maze.initialize();
						MazeArea.setText(maze.toString());
						StateLabel.setText("Maze Created! Have Fun!");
						enableInterface();

					}
					else
					{
						maze = new MazeGame(MazeBuilder.generateMaze(dim), nodrag);
						maze.initialize();
						MazeArea.setText(maze.toString());
						StateLabel.setText("Maze Created! Have Fun!");
						enableInterface();
					}
				}
				else
				{
					StateLabel.setForeground(Color.RED);
					StateLabel.setText("Invalid Arguments! Please Try Again");
				}
			}
		});
		GenerateButton.setBounds(305, 15, 185, 33);
		Window.getContentPane().add(GenerateButton);

		CloseButton = new JButton("Close");
		CloseButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		CloseButton.setBounds(305, 59, 185, 33);
		Window.getContentPane().add(CloseButton);

		UpButton = new JButton("\u2191");
		UpButton.setEnabled(false);
		UpButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		UpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updateGame(Direction.UP);
			}
		});
		UpButton.setBounds(373, 119, 57, 57);
		Window.getContentPane().add(UpButton);

		LeftButton = new JButton("\u2190");
		LeftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				updateGame(Direction.LEFT);
			}
		});
		LeftButton.setEnabled(false);
		LeftButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LeftButton.setBounds(313, 176, 57, 57);
		Window.getContentPane().add(LeftButton);

		RigthButton = new JButton("\u2192");
		RigthButton.setEnabled(false);
		RigthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updateGame(Direction.RIGHT);
			}
		});
		RigthButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		RigthButton.setBounds(433, 176, 57, 57);
		Window.getContentPane().add(RigthButton);

		DownButton = new JButton("\u2193");
		DownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updateGame(Direction.DOWN);
			}
		});
		DownButton.setEnabled(false);
		DownButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		DownButton.setBounds(373, 236, 57, 57);
		Window.getContentPane().add(DownButton);

		StateLabel = new JLabel("Can Generate new Maze!");
		StateLabel.setBounds(20, 304, 256, 33);
		Window.getContentPane().add(StateLabel);

		MazeArea = new JTextArea();
		MazeArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		MazeArea.setEditable(false);
		MazeArea.setBounds(19, 119, 257, 174);
		Window.getContentPane().add(MazeArea);
	}

	public void enableInterface()
	{
		UpButton.setEnabled(true);
		DownButton.setEnabled(true);
		LeftButton.setEnabled(true);
		RigthButton.setEnabled(true);
	}

	public void disableInterface()
	{
		UpButton.setEnabled(false);
		DownButton.setEnabled(false);
		LeftButton.setEnabled(false);
		RigthButton.setEnabled(false);
	}
	
	public void updateGame(Direction move)
	{
		maze.updateHero(move);
		maze.updateDragons();
		MazeArea.setText(maze.toString());
		if(maze.getState() == State.LOST)
		{
			disableInterface();
			StateLabel.setText("Game Over, you Lost! Insert Coin to Try Again");
			//MazeArea.setText("");
			
		}
		else if(maze.getState() == State.WON)
		{
			disableInterface();
			StateLabel.setText("You Won! Congratulations!");
			//MazeArea.setText("");
		}
	}
}


