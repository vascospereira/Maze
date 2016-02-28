package Maze;

public class Hero 
{
	char Hero = 'H'; //Hero character
	int HeroX = 1;	//Hero position X
	int HeroY = 1;	//Hero position Y
	
	public void HeroDeploy(Table table)
	{
		table.table[HeroY][HeroX] = Hero;
	}
}
