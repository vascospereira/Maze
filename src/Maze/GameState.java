package Maze;

public class GameState {
	public enum State { PLAYING, WON, LOST };
	
	static private State state;
	
	static public void setState(State state)
	{
		GameState.state = state;
	}
	
	static public State getState()
	{
		return state;
	}
}
