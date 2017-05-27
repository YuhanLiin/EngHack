package application;
import hitbox.Hitbox;
import game.Game;


public class CharacterSm {
	enum Movement{Still, LeftRight, UpDown, Dash};
	enum Attack{Passive, Attack};
	public Hitbox object;
	Game enviroment;
	Movement move;
	Attack attack;
	int healthPoints;
	int attackPoints;
	int speedPointsX;
	int speedPointsY;
	int direction;
	int cooldown;
	
	public CharacterSm(Game enviro) {
		object.x = 0;
		object.y = 0;
		cooldown = 0;
		speedPointsX = 0;
		speedPointsY = 0;
		healthPoints = 0;
		enviroment = enviro;
	}
	public void move(){
		if(object.x+speedPointsX >=enviroment.width){
			object.x = enviroment.width-(object.width/2);
		}
		else if(object.x+speedPointsX<=0){
			object.x=(object.width)/2;
		}
		if(object.y+speedPointsY >=enviroment.height){
			object.y = enviroment.width-(object.height/2);
		}
		else if(object.y+speedPointsY<=0){
			object.y=(object.height)/2;
		}
		else{
			object.x = object.x +speedPointsX;
			object.y = object.y +speedPointsY;
		}
	}
	public void attack(){
		
	}
	public void dash(int multiplier){
		
	}

}
