package logica_interna;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MejoraDoble extends GameObject{
	
	public MejoraDoble(float x, float y, float velx, float vely) {
		super(x, y);
		this.velX = velx;
		this.velY = vely;
		this.id = ID.PowerUp;

	}
	public void move() {
		x += velX;
		y += velY;
	}
	@Override
	public void tick() {
		move();
	}

	@Override
	public void render(Graphics g) {
		g.fillRect((int)x,(int)y, 22, 22);
		g.setColor(Color.magenta);
		
	}

	@Override
	public Rectangle getRectangle() {
		// TODO Auto-generated method stub
		return new Rectangle(22, 22, 0, 0);
	}

	@Override
	public void paint(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

}
