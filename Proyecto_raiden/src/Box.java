import java.awt.*;

public class Box extends GameObject {

	public Box(int x, int y,float velx,float vely,ID id) {
		super(x,y,id);
		this.velX = velx;
		this.velY = vely;

	}

	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 32);
		
	}

	public Rectangle getRectangle() {
		return new Rectangle(x,y,32,32);
	}
	
	
}
