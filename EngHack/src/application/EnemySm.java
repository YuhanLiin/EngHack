package application;

import game.Game;

public class EnemySm extends CharacterSm {
	
	enum enemyState {SPAWNED, movingLeft, movingRight, movingDown, movingUp, DEAD};
	enum initialPos {bottomRight, bottomLeft, topRight, topLeft}
	
	enemyState myEnemyFSMState = enemyState.SPAWNED;
	initialPos myEnemyInitialPos = initialPos.bottomRight;

	public EnemySm(Game enviro) {
		super(enviro);
		// TODO Auto-generated constructor stub
		
		switch(myEnemyFSMState) {
			case SPAWNED:
				switch(myEnemyInitialPos) {
					case bottomRight: 
						myEnemyFSMState = enemyState.movingLeft;
						break;
					case bottomLeft:
						myEnemyFSMState = enemyState.movingRight;
						break;
					case topRight:
						myEnemyFSMState = enemyState.movingDown;
						break;
					case topLeft:
						myEnemyFSMState = enemyState.movingDown;
						break;
				}
				break;
			case movingRight:
				moveRight();
				break;
			case movingLeft:
				moveLeft();
				break;
			case movingDown:
				moveDown();
				break;
			case movingUp:
				moveUp();
				break;
			case DEAD:
				getKilled();
				break;
		}
	}
	
	int positionX;
	int positionY;
	int maxX;
	int minX;
	int maxY;
	int minY;
	boolean gotHit;
	
	public void moveRight() {
		if (positionX < maxX) {
			positionX++;
		}
		else {
			myEnemyFSMState = enemyState.movingLeft;
		}
	}
	
	public void moveLeft() {
		if (positionX > minX) {
			positionX--;
		}
		else {
			myEnemyFSMState = enemyState.movingRight;
		}
	}
	
	public void moveUp() {
		if (positionY < maxY) {
			positionY++;
		}
		else {
			myEnemyFSMState = enemyState.movingDown;
		}
	}
	
	public void moveDown() {
		if (positionY > minY) {
			positionY--;
		}
		else {
			myEnemyFSMState = enemyState.movingUp;
		}
	}
	
	public void getKilled() {
		
	}
}
