package hitbox;

public class Hitbox {
	public int x;
	public int y;
	public int height;
	public int width;
	
	public Hitbox(int px, int py, int h, int w){
		x = px;
		y = py;
		height = h;
		width = w;
	}
	
	public boolean collide(Hitbox hitbox){
		if (Math.abs(x - hitbox.x) < width/2 + hitbox.width/2
			&& Math.abs(y - hitbox.y) < height/2 + hitbox.height/2){
			return true;
		}
		return false;
	}
}
