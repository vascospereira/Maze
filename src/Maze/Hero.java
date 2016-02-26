package Maze;

public class Hero 
{
	char Hero = 'H'; //Hero character
	int HeroX = 1;	//Hero position X
	int HeroY = 1;	//Hero position Y
	
	public void HeroPosition(Table table)
	{
		table.table[1][1] = Hero;
	}
}
