package Maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Maze.logic.*;

/**
 * 
 * Window Class
 *
 */
public class Window {

	/**
	 * Place for the game components 
	 */
	
	private JFrame Window;
	private JTextField NofDragonsField;
	private JTextField DimensionsField;

	private JLabel NofDragonsLabel;
	private JLabel DimensionsLabel;
	private JLabel DragonTypeLabel;
	private JComboBox<String> DragonTypeCombo;
	private JButton GenerateButton;
	private JButton CloseButton;
	private JButton Design;
	private WindowFrame MazePanel;
	//private JTextArea MazeArea;

	

	public enum DragonState { STATIC, MOVING }
	static DragonState dragonState;
	static MazeGame maze;


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
	public Window() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		Window = new JFrame();
		Window.setTitle("Mazes & Dragons");
		Window.setResizable(false);
		Window.setBounds(100, 100, 517, 635);
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

				if(DragonTypeCombo.getSelectedItem() == "In Movement")
					dragonState = DragonState.MOVING;
				else
					dragonState = DragonState.STATIC;

				int dim;
				dim = Integer.parseInt(DimensionsField.getText());

				int nodrag;
				nodrag = Integer.parseInt(NofDragonsField.getText());

				if((dim == 0) || (dim >= 5 && nodrag >= 1 && nodrag <= 3 && dim % 2 == 1))
				{
					if(dim == 0)
					{
						maze = new MazeGame(1);
						maze.initialize();
						/**AQUIIIII*/
						Window.repaint();
						MazePanel.requestFocus();

					}
					else
					{
						maze = new MazeGame(MazeBuilder.generateMaze(dim), nodrag);
						maze.initialize();
						/**AQUIIIII*/
						Window.repaint();
						MazePanel.requestFocus();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Size must be ODD number, minimum of 5. Number of Dragons must be from 1 to 3", "Invalid Maze", JOptionPane.WARNING_MESSAGE);	
					
				}
			}
		});
		GenerateButton.setBounds(305, 15, 185, 22);
		Window.getContentPane().add(GenerateButton);

		CloseButton = new JButton("Close");
		CloseButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		CloseButton.setBounds(305, 75, 185, 22);
		Window.getContentPane().add(CloseButton);

		MazePanel = new WindowFrame();
		MazePanel.setBounds(19, 119, 471, 471);
		Window.getContentPane().add(MazePanel);

		Design = new JButton("Maze Builder");
		Design.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JTextField text = new JTextField();
				text.setText("11");
				int option = JOptionPane.showOptionDialog(null, text, "Enter maze size", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);	
				int msize = Integer.parseInt(text.getText());
				if(msize == 1)
				{
					JOptionPane.showMessageDialog(null, "Can't Build Maze with 1 as a size", "Invalid Maze", JOptionPane.WARNING_MESSAGE);	
					
					return;
				}
				if(option == JOptionPane.OK_OPTION)
				{
					Design bldr = new Design(msize);
					bldr.setVisible(true);
					
					if(bldr.isValid() == true)
					{
						maze = new MazeGame(DesignFrame.table);
						Window.repaint();
						if(DragonTypeCombo.getSelectedItem() == "In Movement")
							dragonState = DragonState.MOVING;
						else
							dragonState = DragonState.STATIC;
					}
					
				}
				MazePanel.requestFocus();
			}
		});
		Design.setBounds(305, 45, 185, 22);
		Window.getContentPane().add(Design);

	}
}

