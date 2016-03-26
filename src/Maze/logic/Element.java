package Maze.logic;

public class Element {

	private int y, x;
	private char ELEM;
	
	public Element(int y, int x, char elem) {
		super();
		this.y = y;
		this.x = x;
		ELEM = elem;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public char getElem() {
		return ELEM;
	}
	public void setElem(char elem) {
		ELEM = elem;
	}
	
	public void setCoord(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Element: " + ELEM + "\n");
		sb.append("Position X : " + x + "\n");
		sb.append("Position Y : " + y + "\n");
		
		return sb.toString();
	}
	
}
