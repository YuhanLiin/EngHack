package hitbox;

import application.CharacterSm;

public abstract class Attack {
	public boolean isDone = false;
	public int hitId;
	public Hitbox hitbox;
	CharacterSm character;
	
	public Attack(CharacterSm c, int x, int y, int h, int w){
		hitbox = new Hitbox(x, y, h, w);
		character = c;
	}
	
	public abstract void hitEffect(CharacterSm character); 
}
