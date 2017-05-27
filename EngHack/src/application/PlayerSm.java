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
		System.out.println(playerMovement);
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
				break;
				
			case left:
				moveLeft();
				direction = 4;
				if(dashCode =='p'){
					dashFrames =20;
					playerMovement = move.dash;
				}
				else if (keyCode =='i'){
					playerMovement = move.still;
				}
				break;
				
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
				break;
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
				break;
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
				break;
			case dash:
				dash--;
				if(dash<=0){
					speedPointsY = speedPointsY/dash;
					speedPointsX = speedPointsX/dash;
					switch(direction){
					case 1:
							playerMovement = move.up;
							break;
					
					case 2: 
						
							playerMovement = move.right;
							break;
					case 3: 
						
							playerMovement = move.down;
							break;
					case 4:
						
							playerMovement = move.left;
							break;
					default: 
						playerMovement = move.still;
						break;
					}
				}
				else{
					speedPointsY = speedPointsY*dash;
					speedPointsX = speedPointsX*dash;
				}
				break;
			default:
				playerMovement = move.still;	
				break;
		}
		super.move();
	}

}
