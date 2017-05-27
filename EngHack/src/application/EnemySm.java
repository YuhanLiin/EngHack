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
				if (object.x >= maxX) {
					myEnemyFSMState = enemyState.movingLeft;
				}
				break;
			case movingLeft:
				moveLeft();
				if (object.x <= minX) {
					myEnemyFSMState = enemyState.movingRight;
				}
				break;
			case movingDown:
				moveDown();
				if (object.y >= maxY) {
					myEnemyFSMState = enemyState.movingUp;
				}
				break;
			case movingUp:
				moveUp();
				if (object.y <= minY) {
					myEnemyFSMState = enemyState.movingDown;
				}
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
	
	public void getKilled() {
		
	}
}
