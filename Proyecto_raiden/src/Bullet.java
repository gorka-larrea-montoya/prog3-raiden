import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{

	public Bullet(int x, int y, ID id) {
		super(x, y, id);
		
	}
	public void tick() {
		x += velX;
		y += -2;
		if (y <0) {
			
		}
		
	}
	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(x, y, 8, 16);
		
	}
	public Rectangle getRectangle() {
		return new Rectangle(x,y,8,16);
	}

}
