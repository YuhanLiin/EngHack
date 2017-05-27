package game;

public class Game {
	public final int height;
	public final int width;
	public ArrayList<CharacterSm> enemies = ArrayList<CharacterSm>();
	public ArrayList<Attack> playerAttacks = ArrayList<Attack>();
	public ArrayList<Attack> enemyAttacks = ArrayList<Attack>();
	public CharacterSm player;
}
