import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class PowerUp extends GameObject{

	public PowerUp(int x, int y) {
		super(x, y);
		this.id = id.PowerUp;
		this.velY=-2;
		this.velX=0;
		int contadorguion = 0;
	}

	@Override
	public void tick() {
		contadorGuion++;
		x += velX;
		y += velY;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(51, 107, 62));
		g.fillOval(x, y, 12, 12);
	}

	@Override
	public Rectangle getRectangle() {
		return new Rectangle(x,y,12,12);
	}

}
