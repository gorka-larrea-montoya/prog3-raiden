import java.awt.*;

public class Box extends GameObject {

	public Box(int x, int y,float velx,float vely,ID id) {
		super(x,y);
		this.velX = velx;
		this.velY = vely;
		this.id = id.Enemy;

	}

	public void tick() {
		this.contadorGuion++;
		
		x += velX;
		y += velY;
		//System.out.println(contadorGuion);
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 32);
		
	}

	public Rectangle getRectangle() {
		return new Rectangle(x,y,32,32);
	}
	
	
}
