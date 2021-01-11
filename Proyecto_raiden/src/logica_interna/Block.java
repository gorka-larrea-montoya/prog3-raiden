package logica_interna;
import java.awt.*;

public class Block extends GameObject {
//NO USAR MAS POR AHORA
	public Block(float x, float y,float velx,float vely,ID id) {
		super(x,y);
		this.velX = velx;
		this.velY = vely;
		this.id = ID.Block;

	}public void move() {
		setX((int) (getX()+velX));
		setY((int) (getY()+velY));
	}

	public void tick() {
		move();
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x,(int) y, 32, 32);
		
	}

	public Rectangle getRectangle() {
		return new Rectangle((int)x,(int)y,32,32);
	}

	@Override
	public void paint(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
