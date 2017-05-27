package application;

import game.Game;

public class EnemySm extends CharacterSm {
	
	enum enemyState {SPAWNED, movingLeft, movingRight, movingDown, movingUp, DEAD};
	enum initialPos {bottomRight, bottomLeft, topRight, topLeft}

	
	enemyState myEnemyFSMState = enemyState.SPAWNED;
	initialPos myEnemyInitialPos = initialPos.bottomRight;
	
	int positionX;
	int positionY;
	int maxX;
	int minX;
	int maxY;
	int minY;
	boolean gotHit;
	
	public void EnemySm() {
	
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
	
	
	public void moveRight() {
		positionX++;
	}
	public void moveLeft() {
		positionX--;
	}
	public void moveUp() {
		positionY++;
	}
	public void moveDown() {
		positionY--;
	}
	public void getKilled() {
		
	}
}
