package Maze.logic;

/**
 *Element class
 */
public abstract class Element {

	private int y, x;
	private char ELEM;
	/**
	 * Creates an Element 
	 * @param y X coordinate of the Element
	 * @param x Y coordinate of the Element
	 * @param elem Element symbol
	 */
	public Element(int y, int x, char elem) {
		this.y = y;
		this.x = x;
		ELEM = elem;
	}
	/**
	 * Creates a copy Element
	 * 
	 * @param element Element object
	 */
	public Element(Element element) {
		this.y = element.getY();
		this.x = element.getX();
		ELEM = element.getElem();
	}

	/**
	 * Gets the Y coordinate of the Element
	 * 
	 * @return Y coordinate of the Element
	 */
	public int getY() {
		return y;
	}
	/**
	 * Sets the Y position of the Element
	 * 
	 * @param y new Y coordinate of Element
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Gets the X coordinate of the Element
	 * 
	 * @return X coordinate of the Element
	 */
	public int getX() {
		return x;
	}
	/**
	 * Sets the X position of the Element
	 * 
	 * @param x new X coordinate of Element
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Gets ELEM symbol of Element
	 * 
	 * @return ELEM symbol Element
	 */
	public char getElem() {
		return ELEM;
	}
	/**
	 * Sets ELEM symbol of Element
	 * 
	 * @return ELEM Element symbol
	 */
	public void setElem(char elem) {
		ELEM = elem;
	}
	
	/**
	 * Sets coordinates of Elements
	 * 
	 * @param x New X coordinate of the Element
	 * @param y New Y coordinate of the Element
	 */
	public void setCoord(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Creates an ELEM object String
	 * 
	 * @return ELEM as String object
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ELEM);	
		return sb.toString();
	}
	/**
	 * Clones Elements
	 */
	public abstract Element clone();
	
}
