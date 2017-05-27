package application;
import hitbox.Hitbox;
import game.Game;


public class CharacterSm {
	enum Attack{Passive, Attack};
	enum Direction{Right, Left};
	public Hitbox object;
	Game enviroment;
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
	public CharacterSm(){
		
	}
	public void move(){
		if(object.x+speedPointsX +(object.width)/2 >=enviroment.width){
			object.x = enviroment.width-(object.width/2);
		}
		else if(object.x+speedPointsX +(object.width)/2<=0){
			object.x=(object.width)/2;
		}
		if(object.y+speedPointsY + (object.height)/2>=enviroment.height){
			object.y = enviroment.width-(object.height/2);
		}
		else if(object.y+speedPointsY +(object.height)/2<=0){
			object.y=(object.height)/2;
		}
		else{
			object.x = object.x +speedPointsX;
			object.y = object.y +speedPointsY;
		}
	}
	public void attack(EnemySm enemy){
		enemy.healthPoints = healthPoints - attackPoints;
	}
	public void dash(int multiplier){
		speedPointsX = speedPointsX*multiplier;
		speedPointsY = speedPointsY*multiplier;
	}
	public void unDash(int multiplier){
		speedPointsX = speedPointsX/multiplier;
		speedPointsY = speedPointsY/multiplier;
	}

}
