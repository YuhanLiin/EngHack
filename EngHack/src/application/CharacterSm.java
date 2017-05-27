package application;

public class CharacterSm {
	enum Movement{Still, LeftRight, UpDown, Dash};
	enum Attack{Passive, Attack};
	int positionX;
	int positionY;
	int healthPoints;
	int attackPoints;
	int speedPointsX;
	int speedPointsY;
	int direction;
	int cooldown;
	
	public CharacterSm() {
		positionX = 0;
		positionY = 0;
		cooldown = 0;
		speedPointsX = 0;
		speedPointsY = 0;
		healthPoints = 0;
	}
	public void move(){
		positionX = positionX +speedPointsX;
		positionY = positionY +speedPointsY;
	}
	public void attack(){
		
	}
	public void dash(int multiplier){
		int 
	}

}
