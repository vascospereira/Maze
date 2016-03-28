package Maze.logic;

public abstract class Element {

	private int y, x;
	private char ELEM;
	
	public Element(int y, int x, char elem) {
		this.y = y;
		this.x = x;
		ELEM = elem;
	}
	
	public Element(Element element) {
		this.y = element.getY();
		this.x = element.getX();
		ELEM = element.getElem();
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
		sb.append(ELEM);	
		return sb.toString();
	}
	
	public abstract Element clone();
	
}
