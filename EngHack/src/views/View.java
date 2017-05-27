package views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class View extends ImageView {
	private static int cornerToOrigin(int topLeftCoordinate, double viewDimension){
		return (int)((topLeftCoordinate*2 + viewDimension)/2.0);
	}
	private static int originToCorner(int originCoordinate, double viewDimension){
		return (int)(originCoordinate - viewDimension / 2.0);
	}
	public View(Image playerImage){
		super(playerImage);
	}

	public void setX(int x){
		super.setX(originToCorner(x, this.getFitWidth()));
	}
	
	public void setY(int y){
		super.setY(originToCorner(y, this.getFitHeight()));
	}
	
	public int returnX(){
		return cornerToOrigin((int)super.getX(), this.getFitWidth());
	}
	
	public int returnY(){
		return cornerToOrigin((int)super.getY(), this.getFitHeight());
	}
}
