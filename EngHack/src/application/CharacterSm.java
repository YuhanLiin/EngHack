package application;
import game.Game;
import hitbox.Hitbox;
import views.View;
import javafx.scene.image.Image;


public class CharacterSm {
	enum Attack{Passive, Attack};
	enum Direction{Right, Left};
	public Hitbox object;
	Game enviroment;
	Attack attack;
	int healthPoints;
	int attackPoints;
	final int baseSpeed = 10;
	final int maxHealth = 100;
	int speedPointsX;
	int speedPointsY;
	int direction;
	int cooldown;
	public View view;
	
	//Temporary
	public void moveLeft(){
		speedPointsX = -baseSpeed;
		speedPointsY = 0;
	}
	
	public void moveRight(){
		speedPointsX = baseSpeed;
		speedPointsY = 0;
	}
	public void moveDown(){
		speedPointsY = baseSpeed;
		speedPointsX = 0;
	}
	public void moveUp(){
		speedPointsY = -baseSpeed;
		speedPointsX = 0;
	}
	public void stop(){
		speedPointsY = 0;
		speedPointsX = 0;
	}
	
	public CharacterSm(Game enviro, int x, int y, int h, int w) {
		object = new Hitbox(x, y, h, w);
		cooldown = 0;
		speedPointsX = 0;
		speedPointsY = 0;
		healthPoints = maxHealth;
		enviroment = enviro;
		view = new views.View(new Image("Images/Player.jpg"));
		view.setX(x);
		view.setY(y);
		view.setFitHeight(h);
		view.setFitWidth(w);
	}
	public CharacterSm(){
		
	}
	public void move(){
		if(object.x+speedPointsX +(object.width)/2 >=enviroment.width){
			object.x = enviroment.width-(object.width/2);
			view.setX(object.x);
		}
		else if(object.x+speedPointsX +(object.width)/2<=0){
			object.x=(object.width)/2;
			view.setX(object.x);
		}
		if(object.y+speedPointsY + (object.height)/2>=enviroment.height){
			object.y = enviroment.width-(object.height/2);
			view.setY(object.y);
		}
		else if(object.y+speedPointsY +(object.height)/2<=0){
			object.y=(object.height)/2;
			view.setY(object.y);
		}
		else{
			object.x = object.x +speedPointsX;
			object.y = object.y +speedPointsY;
			view.setX(object.x);
			view.setY(object.y);
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
