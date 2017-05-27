package application;

import game.Game;

public class EnemySm extends CharacterSm {
	
	enum enemyState {SPAWNED, movingLeft, movingRight, movingDown, movingUp, DEAD};
	enum initialPos {bottomRight, bottomLeft, topRight, topLeft}
	
	enemyState myEnemyFSMState = enemyState.SPAWNED;
	initialPos myEnemyInitialPos = initialPos.bottomRight;

	public EnemySm(Game enviro, int x, int y, int h, int w) {
		super(enviro, x, y, h, w);
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
	
	int maxX;
	int minX;
	int maxY;
	int minY;
	boolean gotHit;
	
	public void moveRight() {
		if (object.x < maxX) {
			speedPointsX = baseSpeed;
		}
		else {
			myEnemyFSMState = enemyState.movingLeft;
		}
	}
	
	public void moveLeft() {
		if (object.x > minX) {
			speedPointsX = -baseSpeed;
		}
		else {
			myEnemyFSMState = enemyState.movingRight;
		}
	}
	
	public void moveUp() {
		if (object.y < maxY) {
			speedPointsY = baseSpeed;
		}
		else {
			myEnemyFSMState = enemyState.movingDown;
		}
	}
	
	public void moveDown() {
		if (object.y > minY) {
			speedPointsY = -baseSpeed;
		}
		else {
			myEnemyFSMState = enemyState.movingUp;
		}
	}
	
	public void getKilled() {
		
	}
}
