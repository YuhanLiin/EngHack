package game;
import java.util.ArrayList;

import application.*;

public class Game {
	public final int height = 600;
	public final int width = 800;
	public ArrayList<EnemySm> enemies = ArrayList<CharacterSm>();
	public ArrayList<Attack> playerAttacks = ArrayList<Attack>();
	public ArrayList<Attack> enemyAttacks = ArrayList<Attack>();
	public PlayerSm player;
	public int frameCount = 0;
	
	public Game(){
		player = new PlayerSm(this, 300, 400, 100, 100);
		
	}
	
	public void runFrame(){
		frameCount++;
		if (frameCount % (60*5) == 0){
			enemies.add(new EnemySm());
		}
	}
}
