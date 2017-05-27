package application;

import game.Game;

public class PlayerSm extends CharacterSm {
	enum move{left,right, up,down, still, dash};
	move playerMovement = move.still;
	int dashFrames;
	int dash;

	public PlayerSm(Game enviro, int x, int y, int h, int w) {
		super(enviro, x, y, h, w);
	}
	
	public void Move(char keyCode, char dashCode){
		dash = 2;
	
		switch(playerMovement){
			case still:
				stop();
				direction =0;
				if(keyCode == 'l'){
					playerMovement = move.left;
				}
				else if(keyCode == 'r'){
					playerMovement = move.right;
				}
				else if(keyCode =='u'){
					playerMovement = move.up;
				}
				else if(keyCode =='d'){
					playerMovement = move.down;
				}
				
			case left:
				moveLeft();
				direction = 4;
				if(dashCode =='p'){
					dashFrames =20;
					playerMovement = move.dash;
				}
				
			case right:
				moveRight();
				direction = 2;
				if(dashCode =='p'){
					dashFrames =20;
					playerMovement = move.dash;
				}
				else if (keyCode =='i'){
					playerMovement = move.still;
				}
			case down:
				moveDown();
				direction = 3;
				if(keyCode =='p'){
					dashFrames =20;
					playerMovement = move.dash;
				}
				else if (keyCode =='i'){
					playerMovement = move.still;
				}
			case up:
				moveUp();
				direction = 1;
				if(dashCode =='p'){
					dashFrames =20;
					playerMovement = move.dash;
				}
				else if (keyCode =='i'){
					playerMovement = move.still;
				}
			case dash:
				dash--;
				speedPointsY = speedPointsY*dash;
				speedPointsX = speedPointsX*dash;
				if(dash<=0){
					speedPointsY = speedPointsY/dash;
					speedPointsX = speedPointsX/dash;
					switch(direction){
					case 1:
						
							playerMovement = move.up;
						
					
					case 2: 
						
							playerMovement = move.right;
						
					case 3: 
						
							playerMovement = move.down;
						
					case 4:
						
							playerMovement = move.left;
						
				default: 
					playerMovement = move.still;
					
					}
				}
			default:
				playerMovement = move.still;
				
				
		}
	}

}
