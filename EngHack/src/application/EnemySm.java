package application;

public class EnemySm {
	
	public EnemySm(Game environment) {
		state = FSM.spawned;
		gotHit = false;
	}
	
	enum FSM {spawned, topLeft, topRight, bottomLeft, bottomRight, dead};
	
	private int positionX;
	private int positionY;
	private int maxX;
	private int minX;
	private int maxY;
	private int minY;

	private boolean gotHit;
	private FSM state;
	
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
}
